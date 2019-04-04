package com.zxl.sb.mapper;

import com.zxl.sb.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @author zxl
 * @since 2019-03-07
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    @Delete("DELETE FROM sys_user_role WHERE user_id = #{userId}")
    Boolean deleteByUserId(@Param("userId") Integer userId);

    @Delete("DELETE FROM sys_user_role WHERE role_id = #{roleId}")
    Boolean deleteByRoleId(@Param("roleId") Integer roleId);
}
