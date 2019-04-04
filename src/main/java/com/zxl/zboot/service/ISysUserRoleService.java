package com.zxl.zboot.service;

import com.zxl.zboot.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户角色表 服务类
 * </p>
 *
 * @author zxl
 * @since 2019-03-07
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    /**
     * 根据用户ID删除该用户的角色关系
     *
     * @param userId 用户ID
     * @return
     */
    Boolean deleteByUserId(Integer userId);

    /**
     * 根据角色ID删除该角色和用户绑定的关系
     *
     * @param roleId
     * @return
     */
    Boolean deleteByRoleId(Integer roleId);

}
