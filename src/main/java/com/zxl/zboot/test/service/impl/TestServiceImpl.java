package com.zxl.zboot.test.service.impl;

import com.zxl.zboot.test.entity.Test;
import com.zxl.zboot.test.mapper.TestMapper;
import com.zxl.zboot.test.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxl
 * @since 2019-04-18
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
