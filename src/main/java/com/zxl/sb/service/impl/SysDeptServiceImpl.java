package com.zxl.sb.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.sb.dto.DeptDto;
import com.zxl.sb.dto.DeptTree;
import com.zxl.sb.entity.SysDept;
import com.zxl.sb.entity.SysDeptRelation;
import com.zxl.sb.mapper.SysDeptMapper;
import com.zxl.sb.service.ISysDeptRelationService;
import com.zxl.sb.service.ISysDeptService;
import com.zxl.sb.common.utils.R;
import com.zxl.sb.common.utils.TreeUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackFor = Exception.class)
    public R saveDept(DeptDto deptDto) {
        SysDept sysDept = new SysDept();
        BeanUtils.copyProperties(deptDto, sysDept);
        this.save(sysDept);

        //TODO 插入部门关系
        sysDeptRelationService.insertDeptRelation(sysDept);

        return new R<>(Boolean.TRUE);
    }

    @Override
    public R updateDept(DeptDto deptDto) {
        SysDept sysDept = new SysDept();
        BeanUtils.copyProperties(deptDto, sysDept);
        sysDept.setUpdateTime(new Date());
        this.updateById(sysDept);

        //TODO 如果父级改变，更新部门关系
        SysDept oldDept = this.getById(deptDto.getId());
        if (!oldDept.getParentId().equals(sysDept.getParentId())) {
            sysDeptRelationService.deleteAllDeptRelation(sysDept.getId());
            sysDeptRelationService.insertDeptRelation(sysDept);
        }

        return new R<>(Boolean.TRUE);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean logicDeleteDeptById(Integer id) {
        //级联删除部门（逻辑删除）
        List<Integer> idList = sysDeptRelationService
                .list(Wrappers.<SysDeptRelation>query().lambda()
                        .eq(SysDeptRelation::getAncestor, id))
                .stream()
                .map(SysDeptRelation::getDescendant)
                .collect(Collectors.toList());


        if (CollUtil.isNotEmpty(idList)) {
            this.removeByIds(idList);
        }

        //删除部门级联关系
        sysDeptRelationService.deleteAllDeptRelation(id);

        return Boolean.TRUE;
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
     * @param deptList 部门
     * @return
     */
    private List<DeptTree> getDeptTree(List<SysDept> deptList) {
        List<DeptTree> treeList = deptList.stream()
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
