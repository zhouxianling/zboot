package com.zxl.zboot.sys.service;

import com.zxl.zboot.sys.dto.RoleDto;
import com.zxl.zboot.sys.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxl.zboot.common.utils.R;

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

    R saveOrUpdateRole(RoleDto roleDto);


    List<RoleDto> findRoleByUserId(Integer userId);
}
