package com.zxl.sb.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 部门关系表
 * </p>
 *
 * @author zxl
 * @since 2019-03-01
 */
@Data
@Accessors(chain = true)
public class SysDeptRelation implements Serializable {

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
