package com.zxl.zboot.sys.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zxl.zboot.sys.entity.SysDept;
import com.zxl.zboot.sys.entity.SysDeptRelation;
import com.zxl.zboot.sys.mapper.SysDeptRelationMapper;
import com.zxl.zboot.sys.service.ISysDeptRelationService;
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


        List<SysDeptRelation> relationList = baseMapper.selectList(Wrappers.<SysDeptRelation>query().lambda()
                .eq(SysDeptRelation::getDescendant, sysDept.getParentId()))
                .stream().map(relation -> {
                    relation.setDescendant(sysDept.getId());
                    return relation;
                }).collect(Collectors.toList());


        if (CollUtil.isNotEmpty(relationList)) {
            this.saveBatch(relationList);
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
}
