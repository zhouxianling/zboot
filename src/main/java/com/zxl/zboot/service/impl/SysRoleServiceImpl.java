package com.zxl.zboot.service.impl;

import com.zxl.zboot.dto.RoleDto;
import com.zxl.zboot.entity.SysRole;
import com.zxl.zboot.mapper.SysRoleMapper;
import com.zxl.zboot.service.ISysRoleMenuService;
import com.zxl.zboot.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.zboot.common.utils.R;
import com.zxl.zboot.service.ISysUserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author zxl
 * @since 2019-03-06
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    private final ISysUserRoleService sysUserRoleService;
    private final ISysRoleMenuService sysRoleMenuService;

    @Override
    public R saveOrUpdateRole(RoleDto roleDto) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(roleDto, sysRole);
        this.saveOrUpdate(sysRole);
        sysRoleMenuService.saveRoleMenus(sysRole.getId(), roleDto.getMenuIds());
        return new R<>(sysRole);
    }


    @Override
    public boolean removeById(Serializable id) {
        super.removeById(id);
        sysUserRoleService.deleteByRoleId((Integer) id);
        return Boolean.TRUE;
    }

    @Override
    public List<RoleDto> findRoleByUserId(Integer userId) {
        return baseMapper.findRoleByUserId(userId);
    }
}
