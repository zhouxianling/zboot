package com.zxl.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.demo.common.exception.CustomException;
import com.zxl.demo.common.utils.JwtUtil;
import com.zxl.demo.common.utils.PasswordHash;
import com.zxl.demo.dto.MenuDto;
import com.zxl.demo.dto.RoleDto;
import com.zxl.demo.dto.UserDto;
import com.zxl.demo.dto.UserInfo;
import com.zxl.demo.entity.SysUser;
import com.zxl.demo.entity.SysUserRole;
import com.zxl.demo.mapper.SysUserMapper;
import com.zxl.demo.service.*;
import com.zxl.demo.common.utils.R;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zxl
 * @since 2019-03-01
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    private final ISysMenuService sysMenuService;
    private final ISysRoleService sysRoleService;
    private final ISysDeptService sysDeptService;
    private final ISysUserRoleService sysUserRoleService;
    private final ISysDeptRelationService sysDeptRelationService;
    private final RedisTemplate<String, Serializable> redisTemplate;


    @Override
    public R login(String username, String password) {
        UserDto userDto = this.findByUsername(username);
        if (userDto == null) {
            return new R<>(400, "用户不存在.");
        } else {
            try {
                if (PasswordHash.validatePassword(password, userDto.getPassword())) {
                    String token = JwtUtil.generateToken(username);
                    userDto.setRoles(sysRoleService.findRoleByUserId(userDto.getId()));
                    redisTemplate.opsForValue().set(userDto.getUsername(), userDto);

                    return new R<>(token);
                } else {
                    return new R<>(400, "参数错误.");
                }
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                e.printStackTrace();
            }
        }
        return new R<>(400, "登录失败.");
    }

    @Override
    public R register(UserDto userDto) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDto, sysUser);
        try {
            sysUser.setPassword(PasswordHash.createHash(sysUser.getPassword()));
            this.save(sysUser);
            List<RoleDto> roles = userDto.getRoles();
            //TODO 更新用户和角色关系
            if (CollUtil.isNotEmpty(roles)) {
                for (RoleDto role : roles) {
                    SysUserRole sysUserRole = new SysUserRole();
                    sysUserRole.setUserId(sysUser.getId());
                    sysUserRole.setRoleId(role.getId());
                    sysUserRoleService.save(sysUserRole);
                }
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return new R<>(sysUser);
    }

    @Override
    public UserDto findByUsername(String username) {
        return this.baseMapper.findByUsername(username);
    }

    @Override
    public UserInfo findUserInfo(SysUser sysUser) {
        return null;
    }

    @Override
    public IPage getUsersWithRolePage(Page page, UserDto userDto) {
        return null;
    }

    @Override
    public R<Boolean> updateUserInfo(UserDto userDto) {
        return null;
    }

    @Override
    public Boolean updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public List<SysUser> listAncestorUsers(String username) {
        return null;
    }


    @Override
    public List<MenuDto> findMenuByUserId(Integer id) {
        return this.baseMapper.findMenuByUserId(id);
    }
}
