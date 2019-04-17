package com.zxl.zboot.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxl.zboot.sys.dto.UserDto;
import com.zxl.zboot.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
