package com.zxl.sb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxl.sb.dto.MenuDto;
import com.zxl.sb.entity.SysMenu;
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

    @Select("SELECT * FROM sys_menu WHERE del_flag =0 AND  id IN (SELECT menu_id FROM sys_role_menu WHERE role_id = (SELECT role_id FROM sys_user_role WHERE user_id = #{id}))")
    List<MenuDto> findMenuByUserId(@Param("id") Integer integer);
}
