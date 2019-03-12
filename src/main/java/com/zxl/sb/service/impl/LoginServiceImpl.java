package com.zxl.sb.service.impl;

import com.zxl.sb.common.utils.JwtUtil;
import com.zxl.sb.common.utils.PasswordHash;
import com.zxl.sb.common.utils.R;
import com.zxl.sb.dto.MenuTree;
import com.zxl.sb.dto.RoleDto;
import com.zxl.sb.dto.UserDto;
import com.zxl.sb.service.*;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author xianLing.zhou
 * @since 2019/3/8
 */
@Service
@AllArgsConstructor
public class LoginServiceImpl implements ILoginService {

    private final ISysUserService sysUserService;
    private final ISysRoleService sysRoleService;
    private final ISysMenuService sysMenuService;
    private final RedisTemplate<String, Serializable> redisTemplate;


    @Override
    public R login(String username, String password) {
        UserDto userDto = sysUserService.findByUsername(username);
        if (userDto == null) {
            return new R<>(400, "用户不存在.");
        } else {
            try {
                if (PasswordHash.validatePassword(password, userDto.getPassword())) {
                    String token = JwtUtil.generateToken(username);
                    redisTemplate.opsForValue().set(userDto.getUsername(), userDto);

                    List<RoleDto> roles = sysRoleService.findRoleByUserId(userDto.getId());
                    userDto.setRoles(roles);
                    userDto.setToken(token);
                    List<MenuTree> menuTrees = sysMenuService.findMenuByUserId(userDto.getId());
                    userDto.setMenus(menuTrees);

                    return new R<>(userDto);
                } else {
                    return new R<>(400, "参数错误.");
                }
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                e.printStackTrace();
            }
        }
        return new R<>(400, "登录失败.");
    }
}
