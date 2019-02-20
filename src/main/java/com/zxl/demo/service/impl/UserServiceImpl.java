package com.zxl.demo.service.impl;

import com.zxl.demo.entity.User;
import com.zxl.demo.mapper.UserMapper;
import com.zxl.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zxl
 * @since 2019-02-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    
}
