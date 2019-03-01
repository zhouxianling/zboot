package com.zxl.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxl.demo.dto.UserDTO;
import com.zxl.demo.entity.SysUser;
import com.zxl.demo.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zxl.demo.common.BaseController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zxl
 * @since 2019-03-01
 */

@Api(tags = "1.0", value = "用户管理", description = "用户管理")
@RestController
@RequestMapping("api/sysUser")
public class SysUserController extends BaseController {

    @Autowired
    ISysUserService sysUserService;


    @ApiOperation("列表")
    @GetMapping("/page")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "关键字查询", name = "keyword")
    })
    public Object page(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "10") int size
            , @RequestParam(defaultValue = "") String keyword) {
        return sysUserService.page(new Page<>(page, size), new QueryWrapper<SysUser>().like("username", keyword));
    }


}
