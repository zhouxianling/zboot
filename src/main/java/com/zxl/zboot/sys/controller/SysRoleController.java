package com.zxl.zboot.sys.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxl.zboot.common.exception.CustomException;
import com.zxl.zboot.sys.dto.RoleDto;
import com.zxl.zboot.sys.entity.SysRole;
import com.zxl.zboot.sys.service.ISysRoleMenuService;
import com.zxl.zboot.sys.service.ISysRoleService;
import com.zxl.zboot.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.zxl.zboot.common.BaseController;

/**
 * <p>
 * 系统角色表 前端控制器
 * </p>
 *
 * @author zxl
 * @since 2019-03-06
 */
@Api(tags = "1.2", value = "角色管理", description = "角色管理")
@RestController
@RequestMapping("api/role")
@AllArgsConstructor
public class SysRoleController extends BaseController {

    private final ISysRoleService sysRoleService;
    private final ISysRoleMenuService sysRoleMenuService;


    @ApiOperation(value = "新增或更新")
    @PostMapping
    public R saveOrUpdate(@RequestBody RoleDto roleDto) {
        return sysRoleService.saveOrUpdateRole(roleDto);
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


    @ApiOperation(value = "删除角色")
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Integer id) {
        if (id == 1) {
            throw new CustomException(401, "系统角色不支持删除");
        }
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
    @GetMapping("/menu")
    public R saveRoleMenus(@RequestParam Integer roleId, @RequestParam(required = false) String menuIds) {
        if (roleId == 1) {
            throw new CustomException(401, "系统角色不支持修改");
        }
        return new R<>(sysRoleMenuService.saveRoleMenus(roleId, menuIds));
    }


}
