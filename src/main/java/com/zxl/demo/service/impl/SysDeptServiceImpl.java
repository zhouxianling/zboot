package com.zxl.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.demo.dto.DeptDTO;
import com.zxl.demo.dto.DeptTree;
import com.zxl.demo.entity.SysDept;
import com.zxl.demo.entity.SysDeptRelation;
import com.zxl.demo.mapper.SysDeptMapper;
import com.zxl.demo.service.ISysDeptRelationService;
import com.zxl.demo.service.ISysDeptService;
import com.zxl.demo.utils.TreeUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 部门管理 服务实现类
 * </p>
 *
 * @author zxl
 * @since 2019-03-01
 */
@Service
@AllArgsConstructor
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

    private final ISysDeptRelationService sysDeptRelationService;

    @Override
    public SysDept insertOrUpdate(DeptDTO deptDTO) {
        SysDept sysDept = new SysDept();
        BeanUtils.copyProperties(deptDTO, sysDept);
        //TODO 更新操作
        if (sysDept.getId() != null) {
            sysDept.setUpdateTime(new Date());
            this.saveOrUpdate(sysDept);
            //TODO 更新部门关系
            SysDeptRelation relation = new SysDeptRelation();
            relation.setAncestor(sysDept.getParentId());
            relation.setDescendant(sysDept.getId());
            sysDeptRelationService.updateDeptRelation(relation);
        } else {
            sysDept.setCreateTime(new Date());
            this.saveOrUpdate(sysDept);
            //TODO 插入部门关系
            sysDeptRelationService.insertDeptRelation(sysDept);
        }
        return sysDept;
    }

    @Override
    public Boolean logicDeleteDeptById(Long id) {
        SysDept sysDept = this.getById(id);
        sysDept.setDelFlag(true);
        this.save(sysDept);
        return true;
    }

    @Override
    public List<DeptTree> selectTree() {
        return this.getDeptTree(this.list());
    }

    @Override
    public List<DeptTree> getUserTree() {

        return null;
    }

    /**
     * 构建部门树
     *
     * @param depts 部门
     * @return
     */
    private List<DeptTree> getDeptTree(List<SysDept> depts) {
        List<DeptTree> treeList = depts.stream()
                .filter(dept -> !dept.getId().equals(dept.getParentId()))
                .map(dept -> {
                    DeptTree node = new DeptTree();
                    node.setId(dept.getId());
                    node.setParentId(dept.getParentId());
                    node.setName(dept.getName());
                    return node;
                }).collect(Collectors.toList());

        return TreeUtil.build(treeList, 0);
    }

}
