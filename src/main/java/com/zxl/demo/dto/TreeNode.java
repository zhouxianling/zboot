package com.zxl.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author xianLing.zhou
 * @since 2019/3/6
 */
@Data
public class TreeNode {
    protected int id;
    protected int parentId;

    protected List<TreeNode> children = new ArrayList<TreeNode>();

    public void add(TreeNode node) {
        children.add(node);
    }
}
