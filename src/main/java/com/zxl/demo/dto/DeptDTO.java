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
public class DeptDTO implements Serializable {
    public Long id;
    private String name;
    private Integer sort;
    private Integer parentId;
}
