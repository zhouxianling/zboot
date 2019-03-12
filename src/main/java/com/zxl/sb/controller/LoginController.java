package com.zxl.sb.controller;

import com.zxl.sb.common.utils.R;
import com.zxl.sb.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * </p>
 *
 * @author xianLing.zhou
 * @since 2019/3/8
 */
@Api(tags = "1.0", value = "登录", description = "登录")
@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private final ILoginService loginService;

    @ApiOperation(value = "登陆")
    @PostMapping
    public R login(@RequestParam String username, @RequestParam String password) {
        return loginService.login(username, password);
    }

}
