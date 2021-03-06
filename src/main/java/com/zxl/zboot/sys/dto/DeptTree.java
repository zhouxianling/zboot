package com.zxl.zboot.sys.dto;

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
    private Integer sort;

    //前端用 label就是名称  value就是id
    private String label;
    private String value;
}
