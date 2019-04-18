package com.zxl.zboot.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxl.zboot.sys.dto.MenuDto;
import com.zxl.zboot.sys.entity.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author zxl
 * @since 2019-03-07
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    @Select("SELECT * FROM sys_menu WHERE del_flag =0 AND  id IN (SELECT menu_id FROM sys_role_menu WHERE role_id = (SELECT role_id FROM sys_user WHERE id = #{userId}))")
    List<MenuDto> findMenuByUserId(@Param("userId") Integer userId);


    @Select("SELECT * FROM sys_menu WHERE del_flag =0 AND  id IN (SELECT menu_id FROM sys_role_menu WHERE role_id = #{roleId})")
    List<MenuDto> findMenuByRoleId(@Param("roleId") Integer roleId);

    @Select("SELECT menu_id FROM sys_role_menu WHERE role_id = #{roleId}")
    List<Integer> findMenuIdsByRoleId(@Param("roleId") Integer roleId);

}
