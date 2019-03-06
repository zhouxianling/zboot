package com.zxl.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zxl.demo.entity.SysDept;
import com.zxl.demo.entity.SysDeptRelation;
import com.zxl.demo.mapper.SysDeptRelationMapper;
import com.zxl.demo.service.ISysDeptRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 部门关系表 服务实现类
 * </p>
 *
 * @author zxl
 * @since 2019-03-01
 */
@Service
public class SysDeptRelationServiceImpl extends ServiceImpl<SysDeptRelationMapper, SysDeptRelation> implements ISysDeptRelationService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertDeptRelation(SysDept sysDept) {

        //增加部门关系表
        SysDeptRelation condition = new SysDeptRelation();
        condition.setDescendant(sysDept.getParentId());

        QueryWrapper<SysDeptRelation> qw = new QueryWrapper<>();
        qw.eq("ancestor",sysDept.getParentId());

        List<SysDeptRelation> relations = this.baseMapper.selectList(qw);

        if (CollUtil.isNotEmpty(relations)) {
            this.saveBatch(relations);
        }


        //自己也要维护到关系表中
        SysDeptRelation own = new SysDeptRelation();
        own.setDescendant(sysDept.getId());
        own.setAncestor(sysDept.getId());
        this.baseMapper.insert(own);

    }

    @Override
    public void deleteAllDeptRelation(Integer id) {
        baseMapper.deleteDeptRelationsById(id);
    }

    @Override
    public void updateDeptRelation(SysDeptRelation relation) {
        baseMapper.updateDeptRelations(relation);
    }
}
