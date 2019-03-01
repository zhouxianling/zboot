package com.zxl.demo.entity;

import com.zxl.demo.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 部门管理
 * </p>
 *
 * @author zxl
 * @since 2019-03-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysDept extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    private Integer parentId;


}
