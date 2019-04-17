package com.zxl.zboot.sys.mapper;

import com.zxl.zboot.sys.dto.RoleDto;
import com.zxl.zboot.sys.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 系统角色表 Mapper 接口
 * </p>
 *
 * @author zxl
 * @since 2019-03-06
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("SELECT * FROM sys_role WHERE id IN (SELECT role_id  FROM sys_user_role WHERE user_id = #{userId}) AND del_flag = 0;")
    List<RoleDto> findRoleByUserId(@Param("userId") Integer userId);

}
