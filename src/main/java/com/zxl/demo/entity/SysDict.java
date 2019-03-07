package com.zxl.demo.entity;

import com.zxl.demo.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author zxl
 * @since 2019-03-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysDict extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 数据值
     */
    private String value;

    /**
     * 标签名
     */
    private String label;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序（升序）
     */
    private Integer sort;

    /**
     * 备注信息
     */
    private String remarks;


}
