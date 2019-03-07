package com.zxl.demo.common.filter;

import cn.hutool.core.util.StrUtil;
import com.zxl.demo.common.exception.CustomException;
import com.zxl.demo.common.utils.JwtUtil;
import com.zxl.demo.dto.MenuDto;
import com.zxl.demo.entity.SysMenu;
import com.zxl.demo.entity.SysUser;
import com.zxl.demo.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Slf4j
@Service
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final PathMatcher pathMatcher = new AntPathMatcher();

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (isProtectedUrl(request)) {
                String token = request.getHeader("Authorization");

                //检查jwt令牌, 如果令牌不合法或者过期, 里面会直接抛出异常, 下面的catch部分会直接返回
                JwtUtil.validateToken(token);

                //获取用户信息
                String username = JwtUtil.getUsernameFromToken(token);
                //从redis中获取
                SysUser sysUser = (SysUser) redisTemplate.opsForValue().get(username);
                if (sysUser == null) {
                    sysUser = sysUserService.findByUsername(username);
                    redisTemplate.opsForValue().set(username, sysUser);
                }
                request = JwtUtil.validateTokenAndAddUserIdToHeader(request, sysUser);


                List<MenuDto> menus = sysUserService.findMenuByUserId(sysUser.getId());
                boolean isAuth = false;
                for (MenuDto menu : menus) {
                    if (StrUtil.isNotBlank(menu.getPermission()) && isAuthUrl(menu.getPermission(), request)) {
                        isAuth = true;
                    }
                }
                if (!isAuth) {
                    log.info("权限校验失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        //如果jwt令牌通过了检测, 那么就把request传递给后面的RESTful api
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对地址 /api 开头的api检查jwt
     *
     * @param request
     * @return
     */
    private boolean isProtectedUrl(HttpServletRequest request) {
        return pathMatcher.match("/api/**", request.getServletPath());
    }

    private boolean isAuthUrl(String url, HttpServletRequest request) {
        return pathMatcher.match(url, request.getServletPath());
    }
}
