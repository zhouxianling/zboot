package com.zxl.demo.service;

import com.zxl.demo.dto.MenuDto;
import com.zxl.demo.dto.MenuTree;
import com.zxl.demo.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxl.demo.common.utils.R;

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
    R saveMenu(MenuDto menuDto);

    /**
     * 更新菜单
     *
     * @param menuDto
     * @return
     */
    R updateMenu(MenuDto menuDto);


    /**
     * 通过用户ID 查询他的菜单
     *
     * @param userId 用户ID
     * @return 菜单集
     */
    List<MenuTree> findMenuByUserId(Integer userId);
}
