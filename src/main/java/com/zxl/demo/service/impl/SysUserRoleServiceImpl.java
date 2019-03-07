package com.zxl.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.demo.entity.SysUserRole;
import com.zxl.demo.mapper.SysUserRoleMapper;
import com.zxl.demo.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author zxl
 * @since 2019-03-07
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Override
    public Boolean deleteByUserId(Integer userId) {
        return baseMapper.deleteByUserId(userId);
    }


}
