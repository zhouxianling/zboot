package com.zxl.zboot.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zxl.zboot.common.CommonConstants;
import com.zxl.zboot.common.utils.TreeUtil;
import com.zxl.zboot.dto.MenuDto;
import com.zxl.zboot.dto.MenuTree;
import com.zxl.zboot.entity.SysMenu;
import com.zxl.zboot.entity.SysRoleMenu;
import com.zxl.zboot.mapper.SysMenuMapper;
import com.zxl.zboot.mapper.SysRoleMenuMapper;
import com.zxl.zboot.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.zboot.common.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author zxl
 * @since 2019-03-07
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    private final SysRoleMenuMapper sysRoleMenuMapper;


    @Override
    public R saveOrUpdateMenu(MenuDto menuDto) {
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(menuDto, sysMenu);
        return new R<>(this.saveOrUpdate(sysMenu));
    }


    @Override
    public List<MenuTree> findMenuByUserId(Integer userId) {
        List<MenuTree> menuTrees = TreeUtil.buildMenuDtoTree(baseMapper.findMenuByUserId(userId), 0);
        menuTrees.sort(Comparator.comparing(MenuTree::getSort));
        return menuTrees;
    }

    @Override
    public R removeMenuById(Integer id) {
        // 查询父节点为当前节点的节点
        List<SysMenu> menuList = this.list(Wrappers.<SysMenu>query()
                .lambda().eq(SysMenu::getParentId, id));
        if (CollUtil.isNotEmpty(menuList)) {
            return R.builder()
                    .code(CommonConstants.FAIL)
                    .msg("菜单含有下级不能删除").build();
        }

        sysRoleMenuMapper.delete(Wrappers.<SysRoleMenu>query()
                .lambda().eq(SysRoleMenu::getMenuId, id));

        //删除当前菜单及其子菜单
        return new R<>(this.removeById(id));
    }


}
