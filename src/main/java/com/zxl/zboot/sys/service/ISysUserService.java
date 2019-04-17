package com.zxl.zboot.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxl.zboot.sys.dto.UserDto;
import com.zxl.zboot.sys.dto.UserInfo;
import com.zxl.zboot.sys.entity.SysUser;
import com.zxl.zboot.common.utils.R;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zxl
 * @since 2019-03-01
 */
public interface ISysUserService extends IService<SysUser> {



    /**
     * 注册
     *
     * @param userDto
     * @return
     */
    R register(UserDto userDto);


    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    UserDto findByUsername(String username);

    /**
     * 查询用户信息
     *
     * @param sysUser 用户
     * @return userInfo
     */
    UserInfo findUserInfo(SysUser sysUser);

    /**
     * 分页查询用户信息（含有角色信息）
     *
     * @param page    分页对象
     * @param userDto 参数列表
     * @return
     */
    IPage getUsersWithRolePage(Page page, UserDto userDto);


    /**
     * 更新当前用户基本信息
     *
     * @param userDto 用户信息
     * @return Boolean
     */
    R<Boolean> updateUserInfo(UserDto userDto);

    /**
     * 更新指定用户信息
     *
     * @param userDto 用户信息
     * @return
     */
    Boolean updateUser(UserDto userDto);


    /**
     * 查询上级部门的用户信息
     *
     * @param username 用户名
     * @return R
     */
    List<SysUser> listAncestorUsers(String username);




}
