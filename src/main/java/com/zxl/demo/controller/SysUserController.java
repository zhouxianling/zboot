package com.zxl.demo.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxl.demo.dto.UserDTO;
import com.zxl.demo.entity.SysUser;
import com.zxl.demo.exception.CustomException;
import com.zxl.demo.service.ISysUserService;
import com.zxl.demo.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zxl.demo.common.BaseController;

import static com.alibaba.druid.sql.visitor.SQLEvalVisitorUtils.like;

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
@RequestMapping("api/user")
@AllArgsConstructor
public class SysUserController extends BaseController {

    private final ISysUserService sysUserService;


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
