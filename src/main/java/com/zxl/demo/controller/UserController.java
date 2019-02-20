package com.zxl.demo.controller;


import com.zxl.demo.common.BaseController;
import com.zxl.demo.mapper.UserMapper;
import com.zxl.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxl
 * @since 2019-02-14
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public Object list() {
        return userMapper.getUserList();
    }


    @GetMapping("/page")
    public Object page() {
        return userService.list();
    }


}
