package com.zxl.demo.dto;

import com.zxl.demo.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends SysUser {

    /**
     * 角色ID
     */
    private List<Integer> role;


}
