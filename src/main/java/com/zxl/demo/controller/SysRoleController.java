package com.zxl.demo.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxl.demo.dto.RoleDto;
import com.zxl.demo.entity.SysRole;
import com.zxl.demo.service.ISysRoleMenuService;
import com.zxl.demo.service.ISysRoleService;
import com.zxl.demo.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.zxl.demo.common.BaseController;

/**
 * <p>
 * 系统角色表 前端控制器
 * </p>
 *
 * @author zxl
 * @since 2019-03-06
 */
@Api(tags = "角色", value = "角色管理", description = "角色管理")
@RestController
@RequestMapping("api/role")
@AllArgsConstructor
public class SysRoleController extends BaseController {

    private final ISysRoleService sysRoleService;
    private final ISysRoleMenuService sysRoleMenuService;


    @ApiOperation(value = "新增")
    @PostMapping
    public R save(@RequestBody RoleDto roleDto) {
        return sysRoleService.saveRole(roleDto);
    }


    @ApiOperation(value = "更新")
    @PutMapping
    public R update(@RequestBody RoleDto roleDto) {
        return sysRoleService.updateRole(roleDto);
    }


    @ApiOperation(value = "详情")
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R<>(sysRoleService.getById(id));
    }

    @ApiOperation(value = "通过用户获取所属的角色")
    @GetMapping("/findRoleByUserId/{userId}")
    public R findRoleByUserId(@PathVariable Integer userId) {
        return new R<>(sysRoleService.findRoleByUserId(userId));
    }


    @ApiOperation(value = "删除菜单")
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Integer id) {
        return new R<>(sysRoleService.removeById(id));
    }

    @ApiOperation("分页接口")
    @GetMapping("/page")
    public R page(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "10") int size
            , @RequestParam(required = false) String roleName) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(roleName)) {
            queryWrapper.like("role_name", "%" + roleName + "%");
        }
        return new R<>(sysRoleService.page(new Page<>(page, size), queryWrapper));
    }

    /**
     * 更新角色菜单
     *
     * @param roleId  角色ID
     * @param menuIds 菜单ID拼成的字符串，每个id之间根据逗号分隔
     * @return success、false
     */
    @ApiOperation("更新角色菜单")
    @PutMapping("/menu")
    public R saveRoleMenus(Integer roleId, @RequestParam(value = "menuIds", required = false) String menuIds) {
        SysRole sysRole = sysRoleService.getById(roleId);
        return new R<>(sysRoleMenuService.saveRoleMenus(sysRole.getRoleCode(), roleId, menuIds));
    }


}
