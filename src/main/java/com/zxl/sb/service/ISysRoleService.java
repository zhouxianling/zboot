package com.zxl.sb.service;

import com.zxl.sb.dto.RoleDto;
import com.zxl.sb.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxl.sb.common.utils.R;

import java.util.List;

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

    List<RoleDto> findRoleByUserId(Integer userId);
}
