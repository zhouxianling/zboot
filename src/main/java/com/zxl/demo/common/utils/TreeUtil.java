package com.zxl.demo.common.utils;

import com.zxl.demo.dto.MenuTree;
import com.zxl.demo.dto.TreeNode;
import com.zxl.demo.entity.SysMenu;
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

    /**
     * 通过sysMenu创建树形节点
     *
     * @param menus
     * @param root
     * @return
     */
    public List<MenuTree> buildMenuTree(List<SysMenu> menus, int root) {
        List<MenuTree> trees = new ArrayList<>();
        MenuTree node;
        for (SysMenu menu : menus) {
            node = new MenuTree();
            node.setId(menu.getId());
            node.setParentId(menu.getParentId());
            node.setName(menu.getName());
            node.setPath(menu.getPath());
            node.setPermission(menu.getPermission());
            node.setName(menu.getName());
            node.setComponent(menu.getComponent());
            node.setIcon(menu.getIcon());
            node.setKeepAlive(menu.getKeepAlive());
            trees.add(node);
        }
        return TreeUtil.build(trees, root);
    }

}
