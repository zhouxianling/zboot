package com.zxl.zboot.dto;

import com.zxl.zboot.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends SysUser {

    /**
     * token 信息
     */
    private String token;

    /**
     * 角色ID
     */
    private List<RoleDto> roles;

    /**
     * 菜单id
     */
    private List<MenuTree> menus;

}
