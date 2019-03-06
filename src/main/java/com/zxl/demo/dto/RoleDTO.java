package com.zxl.demo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @author xianLing.zhou
 * @since 2019/3/6
 */
@Data
public class RoleDTO implements Serializable {

    public Long id;

    private String roleName;

    private String roleCode;

    private String roleDesc;
}
