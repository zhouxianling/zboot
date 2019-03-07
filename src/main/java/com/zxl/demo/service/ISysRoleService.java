package com.zxl.demo.service;

import com.zxl.demo.dto.RoleDto;
import com.zxl.demo.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxl.demo.common.utils.R;

/**
 * <p>
 * 系统角色表 服务类
 * </p>
 *
 * @author zxl
 * @since 2019-03-06
 */
public interface ISysRoleService extends IService<SysRole> {

    R saveRole(RoleDto roleDto);

    R updateRole(RoleDto roleDto);
}
