package com.zxl.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * </p>
 *
 * @author xianLing.zhou
 * @since 2019/3/7
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuTree extends TreeNode {
    private String name;
    private String permission;
    private String path;
    private String icon;
    private String component;
    private Integer sort;
    private String keepAlive;
    private String type;
}
