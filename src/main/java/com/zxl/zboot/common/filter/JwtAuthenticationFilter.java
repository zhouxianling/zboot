package com.zxl.zboot.common.filter;

import cn.hutool.core.util.StrUtil;
import com.zxl.zboot.common.utils.JwtUtil;
import com.zxl.zboot.sys.entity.SysUser;
import com.zxl.zboot.sys.service.ISysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Service
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final PathMatcher pathMatcher = new AntPathMatcher();


    private static final String TAG = "JwtAuthenticationFilter";


    private final ISysUserService sysUserService;
    private final RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        response.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        response.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        response.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        response.setHeader("Access-Control-Allow-Credentials", "true");

        if (request.getMethod().equals("OPTIONS")) {
            //跨域资源共享标准新增了一组 HTTP 首部字段，允许服务器声明哪些源站有权限访问哪些资源。
            // 另外，规范要求，对那些可能对服务器数据产生副作用的 HTTP 请求方法（特别是 GET 以外的 HTTP 请求，或者搭配某些 MIME 类型的 POST 请求），
            // 浏览器必须首先使用 OPTIONS 方法发起一个预检请求（preflight request），
            // 从而获知服务端是否允许该跨域请求。服务器确认允许之后，才发起实际的 HTTP 请求。
            // 在预检请求的返回中，服务器端也可以通知客户端，是否需要携带身份凭证（包括 Cookies 和 HTTP 认证相关数据）。
            // 参考：https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Access_control_CORS


            response.setStatus(HttpServletResponse.SC_OK);
            //下面才开始验证是否有权限
        } else {
            if (isProtectedUrl(request)) {
                String token = request.getHeader("Authorization");

                if (StrUtil.isBlank(token)) {
                    log.error(TAG + "---请求接口：" + request.getServletPath() + "---token不能为空.");
                    response.sendError(401, "请传token.");
                } else {
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
                }
            }

            //如果jwt令牌通过了检测, 那么就把request传递给后面的RESTful api
            filterChain.doFilter(request, response);
        }
    }

    /**
     * 对地址 /api 开头的api检查jwt
     *
     * @param request
     * @return
     */
    private boolean isProtectedUrl(HttpServletRequest request) {
        String url = request.getServletPath();
        return pathMatcher.match("/api/**", url);
    }

    private boolean isAuthUrl(String url, HttpServletRequest request) {
        return pathMatcher.match(url, request.getServletPath());
    }
}
