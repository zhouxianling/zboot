package com.zxl.demo.service;

import com.zxl.demo.common.utils.R;

public interface ILoginService {
    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    R login(String username, String password);

}
