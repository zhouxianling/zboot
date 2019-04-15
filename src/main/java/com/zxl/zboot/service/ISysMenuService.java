package com.zxl.zboot.service;

import com.zxl.zboot.dto.MenuDto;
import com.zxl.zboot.dto.MenuTree;
import com.zxl.zboot.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxl.zboot.common.utils.R;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author zxl
 * @since 2019-03-07
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 级联删除菜单
     *
     * @param id 菜单id
     * @return 成功 或失败
     */
    R removeMenuById(Integer id);

    /**
     * 保存菜单
     *
     * @param menuDto
     * @return
     */
    R saveOrUpdateMenu(MenuDto menuDto);


    /**
     * 通过用户ID 查询他的菜单
     *
     * @param userId 用户ID
     * @return 菜单集
     */
    List<MenuTree> findMenuByUserId(Integer userId);


    /**
     * 通过角色ID 查询他的菜单
     *
     * @param roleId 角色ID
     * @return 菜单集
     */
    List<MenuTree> findMenuByRoleId(Integer roleId);

    /**
     * TODO 通过角色 查询他的菜单ids
     *
     * @param roleId 角色ID
     * @return 菜单ID集合
     */
    List<Integer> findMenuIdsByRoleId(Integer roleId);
}
