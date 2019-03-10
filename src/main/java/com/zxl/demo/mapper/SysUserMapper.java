package com.zxl.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxl.demo.dto.MenuDto;
import com.zxl.demo.dto.UserDto;
import com.zxl.demo.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zxl
 * @since 2019-03-01
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("SELECT * FROM sys_user WHERE del_flag = 0 AND username = #{username}")
    UserDto findByUsername(@Param("username") String username);

}
