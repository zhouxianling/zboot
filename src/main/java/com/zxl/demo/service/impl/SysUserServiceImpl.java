package com.zxl.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.demo.dto.MenuDto;
import com.zxl.demo.dto.UserDto;
import com.zxl.demo.dto.UserInfo;
import com.zxl.demo.entity.SysUser;
import com.zxl.demo.mapper.SysUserMapper;
import com.zxl.demo.service.*;
import com.zxl.demo.common.utils.R;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public Boolean saveUser(UserDto userDto) {
        return null;
    }

    @Override
    public List<MenuDto> findMenuByUserId(Integer id) {
        return this.baseMapper.findMenuByUserId(id);
    }
}
