package com.zxl.sb.service;

import com.zxl.sb.common.utils.R;

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
