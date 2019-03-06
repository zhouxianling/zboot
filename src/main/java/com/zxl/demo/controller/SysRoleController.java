package com.zxl.demo.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxl.demo.dto.RoleDTO;
import com.zxl.demo.entity.SysRole;
import com.zxl.demo.entity.SysUser;
import com.zxl.demo.exception.CustomException;
import com.zxl.demo.service.ISysRoleService;
import com.zxl.demo.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import com.zxl.demo.common.BaseController;

import java.util.Date;

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

    @ApiOperation("新增或者更新")
    @PostMapping("/")
    public R saveOrUpdate(RoleDTO roleDTO) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(roleDTO, sysRole);
        //TODO 更新操作
        if (sysRole.getId() != null) {
            sysRole.setUpdateTime(new Date());
        } else {
            sysRole.setCreateTime(new Date());
        }
        sysRoleService.saveOrUpdate(sysRole);
        return new R<>(sysRole);
    }

    @ApiOperation("详情")
    @GetMapping("/detail")
    public R detail(Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        if (sysRole == null) {
            throw new CustomException(400, "角色找不到啦，联系后台");
        }
        return new R<>(sysRole);
    }

    @ApiOperation("逻辑删除")
    @GetMapping("/delete")
    public R delete(Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        if (sysRole == null) {
            throw new CustomException(400, "角色找不到啦，联系后台");
        }
        sysRole.setDelFlag(true);
        sysRoleService.saveOrUpdate(sysRole);
        return new R<>();
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


}
