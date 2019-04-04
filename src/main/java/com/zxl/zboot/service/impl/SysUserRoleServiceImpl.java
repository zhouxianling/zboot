package com.zxl.zboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.zboot.entity.SysUserRole;
import com.zxl.zboot.mapper.SysUserRoleMapper;
import com.zxl.zboot.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author zxl
 * @since 2019-03-07
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Override
    public Boolean deleteByUserId(Integer userId) {
        return baseMapper.deleteByUserId(userId);
    }

    @Override
    public Boolean deleteByRoleId(Integer roleId) {
        return baseMapper.deleteByRoleId(roleId);
    }


}
