package com.zxl.zboot.common.utils;

import com.zxl.zboot.sys.dto.MenuDto;
import com.zxl.zboot.sys.dto.MenuTree;
import com.zxl.zboot.sys.dto.TreeNode;
import com.zxl.zboot.sys.entity.SysMenu;
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
    private <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, int root) {
        List<T> trees = new ArrayList<>();

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
            node.setComponent(menu.getComponent());
            node.setIcon(menu.getIcon());
            node.setKeepAlive(menu.getKeepAlive());
            node.setName(menu.getName());
            node.setCreateTime(menu.getCreateTime());
            node.setUpdateTime(menu.getUpdateTime());
            node.setSort(menu.getSort());
            node.setLabel(menu.getName());
            node.setValue(menu.getId() + "");
            trees.add(node);
        }
        return TreeUtil.build(trees, root);
    }

    public List<MenuTree> buildMenuDtoTree(List<MenuDto> menuDtoList, int root) {
        List<MenuTree> menuTrees = new ArrayList<>();
        MenuTree menuTree;
        for (MenuDto menuDto : menuDtoList) {
            menuTree = new MenuTree();
            menuTree.setParentId(menuDto.getParentId());
            menuTree.setId(menuDto.getId());
            menuTree.setName(menuDto.getName());
            menuTree.setPath(menuDto.getPath());
            menuTree.setPermission(menuDto.getPermission());
            menuTree.setComponent(menuDto.getComponent());
            menuTree.setIcon(menuDto.getIcon());
            menuTree.setKeepAlive(menuDto.getKeepAlive());
            menuTree.setName(menuDto.getName());
            menuTree.setSort(menuDto.getSort());
            menuTree.setValue(menuDto.getId() + "");
            menuTrees.add(menuTree);
        }
        return TreeUtil.build(menuTrees, root);
    }

}
