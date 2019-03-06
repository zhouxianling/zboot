package com.zxl.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门树
 * </p>
 *
 * @author xianLing.zhou
 * @since 2019/3/6
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DeptTree extends TreeNode {
    private String name;
}
