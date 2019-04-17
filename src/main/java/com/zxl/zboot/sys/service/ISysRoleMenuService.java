package com.zxl.zboot.sys.service;

import com.zxl.zboot.sys.entity.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色菜单表 服务类
 * </p>
 *
 * @author zxl
 * @since 2019-03-07
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {
    /**
     * 更新角色菜单
     *
     * @param roleId  角色
     * @param menuIds 菜单ID拼成的字符串，每个id之间根据逗号分隔
     * @return
     */
    Boolean saveRoleMenus(Integer roleId, String menuIds);

}
