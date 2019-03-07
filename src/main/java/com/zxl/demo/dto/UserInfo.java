package com.zxl.demo.dto;

import com.zxl.demo.entity.SysUser;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @author xianLing.zhou
 * @since 2019/3/7
 */
@Data
public class UserInfo implements Serializable {
    /**
     * 用户基本信息
     */
    private SysUser sysUser;
    /**
     * 权限标识集合
     */
    private String[] permissions;

    /**
     * 角色集合
     */
    private Integer[] roles;

}
