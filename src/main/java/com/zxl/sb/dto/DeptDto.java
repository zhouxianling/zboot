package com.zxl.sb.dto;

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
public class DeptDto implements Serializable {
    public Integer id;
    private String name;
    private Integer sort;
    private Integer parentId;
}
