package com.zxl.demo.controller;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxl.demo.common.utils.JwtUtil;
import com.zxl.demo.common.utils.PasswordHash;
import com.zxl.demo.dto.UserDto;
import com.zxl.demo.entity.SysUser;
import com.zxl.demo.common.exception.CustomException;
import com.zxl.demo.service.ISysUserRoleService;
import com.zxl.demo.service.ISysUserService;
import com.zxl.demo.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.zxl.demo.common.BaseController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zxl
 * @since 2019-03-01
 */

@Api(tags = "用户", value = "用户管理", description = "用户管理")
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class SysUserController extends BaseController {

    private final ISysUserService sysUserService;

    @ApiOperation(value = "登陆")
    @PostMapping("/login")
    public R login(@RequestParam String username, @RequestParam String password) {
        return sysUserService.login(username, password);
    }

    @ApiOperation(value = "注册")
    @PostMapping("/")
    public R register(@RequestBody UserDto userDto) {
        return sysUserService.register(userDto);
    }


    @ApiOperation("分页")
    @GetMapping("/page")
    public R page(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "10") int size
            , @RequestParam(required = false) String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(username)) {
            queryWrapper.like("username", username);
        }
        return new R<>(sysUserService.page(new Page<>(page, size), queryWrapper));
    }

    @ApiOperation("测试")
    @GetMapping("/test")
    public R test(@RequestParam int test) {
        if (test < 0) {
            throw new CustomException(400, "这个怕是不能小于0");
        }
        return new R<>(true);
    }


}
