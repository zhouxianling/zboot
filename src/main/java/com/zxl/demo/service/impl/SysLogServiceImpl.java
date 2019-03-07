package com.zxl.demo.service.impl;

import com.zxl.demo.entity.SysLog;
import com.zxl.demo.mapper.SysLogMapper;
import com.zxl.demo.service.ISysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author zxl
 * @since 2019-03-07
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

}
