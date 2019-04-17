package com.zxl.zboot.sys.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.zboot.common.utils.PasswordHash;
import com.zxl.zboot.sys.dto.RoleDto;
import com.zxl.zboot.sys.dto.UserDto;
import com.zxl.zboot.sys.dto.UserInfo;
import com.zxl.zboot.sys.entity.SysUser;
import com.zxl.zboot.sys.entity.SysUserRole;
import com.zxl.zboot.sys.mapper.SysUserMapper;
import com.zxl.zboot.common.utils.R;
import com.zxl.zboot.sys.service.*;
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

}