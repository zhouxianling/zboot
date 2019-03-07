package com.zxl.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zxl.demo.common.CommonConstants;
import com.zxl.demo.dto.MenuDto;
import com.zxl.demo.entity.SysMenu;
import com.zxl.demo.entity.SysRoleMenu;
import com.zxl.demo.mapper.SysMenuMapper;
import com.zxl.demo.mapper.SysRoleMenuMapper;
import com.zxl.demo.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.demo.common.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
    public R saveMenu(MenuDto menuDto) {
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(menuDto, sysMenu);
        return new R<>(this.save(sysMenu));
    }

    @Override
    public R updateMenu(MenuDto menuDto) {
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(menuDto, sysMenu);
        return new R<>(this.updateById(sysMenu));
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
