package com.zxl.demo.utils;

import com.zxl.demo.dto.TreeNode;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author xianLing.zhou
 * @since 2019/3/6
 */
@UtilityClass
public class TreeUtil {
    /**
     * 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @return 部门树
     */
    public <T extends TreeNode> List<T> build(List<T> treeNodes, int root) {

        List<T> trees = new ArrayList<>();

        for (T treeNode : treeNodes) {
            if (root == treeNode.getParentId()) {
                trees.add(treeNode);
            }
            for (T it : treeNodes) {
                if (it.getParentId() == treeNode.getId()) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.add(it);
                }
            }
        }
        return trees;
    }

    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @return
     */
    public <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, int root) {
        List<T> trees = new ArrayList<T>();
        for (T treeNode : treeNodes) {
            if (root == treeNode.getParentId()) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId() == it.getParentId()) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
