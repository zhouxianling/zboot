package com.zxl.demo.service.impl;

import com.zxl.demo.dto.RoleDto;
import com.zxl.demo.entity.SysRole;
import com.zxl.demo.mapper.SysRoleMapper;
import com.zxl.demo.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.demo.common.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author zxl
 * @since 2019-03-06
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {


    @Override
    public R saveRole(RoleDto roleDto) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(roleDto, sysRole);
        return new R<>(this.save(sysRole));
    }

    @Override
    public R updateRole(RoleDto roleDto) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(roleDto, sysRole);
        return new R<>(this.updateById(sysRole));
    }
}
