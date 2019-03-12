package com.zxl.sb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxl.sb.dto.MenuDto;
import com.zxl.sb.entity.SysMenu;
import com.zxl.sb.service.ISysMenuService;
import com.zxl.sb.common.utils.R;
import com.zxl.sb.common.utils.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.zxl.sb.common.BaseController;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author zxl
 * @since 2019-03-07
 */
@Api(tags = "1.3", value = "菜单管理", description = "菜单管理")
@RestController
@RequestMapping("api/menu")
@AllArgsConstructor
public class SysMenuController extends BaseController {

    private final ISysMenuService sysMenuService;


    @ApiOperation(value = "新增菜单")
    @PostMapping
    public R save(@RequestBody MenuDto menuDto) {
        return sysMenuService.saveMenu(menuDto);
    }

    @ApiOperation(value = "更新菜单")
    @PutMapping
    public R update(@RequestBody MenuDto menuDto) {
        return sysMenuService.updateMenu(menuDto);
    }


    @ApiOperation(value = "当前用户的树形菜单")
    @GetMapping("tree/{userId}")
    public R getUserTree(@PathVariable Integer userId) {
        return new R<>(sysMenuService.findMenuByUserId(userId));
    }

    @ApiOperation(value = "通过ID查询菜单的详细信息")
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R<>(sysMenuService.getById(id));
    }


    @ApiOperation(value = "删除菜单")
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Integer id) {
        return sysMenuService.removeMenuById(id);
    }


    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public R page(@RequestParam(required = false, defaultValue = "0") Integer page
            , @RequestParam(required = false, defaultValue = "10") Integer size
            , @RequestParam(required = false, defaultValue = "") String name) {
        return new R<>(sysMenuService.page(new Page<>(page, size)
                , new QueryWrapper<SysMenu>().like("name", "%" + name + "%")));
    }

    @ApiOperation(value = "返回树形菜单集合")
    @GetMapping(value = "/tree")
    public R getTree() {
        return new R<>(TreeUtil.buildMenuTree(sysMenuService.list(Wrappers.emptyWrapper()), 0));
    }


}