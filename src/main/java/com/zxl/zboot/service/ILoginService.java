package com.zxl.zboot.service;

import com.zxl.zboot.common.utils.R;

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
