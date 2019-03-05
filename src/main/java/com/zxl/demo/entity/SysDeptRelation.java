package com.zxl.demo.entity;

import com.zxl.demo.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 部门关系表
 * </p>
 *
 * @author zxl
 * @since 2019-03-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysDeptRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 祖先节点
     */
    private Integer ancestor;

    /**
     * 后代节点
     */
    private Integer descendant;


}
