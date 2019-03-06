package com.zxl.demo.mapper;

import com.zxl.demo.entity.SysDeptRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 部门关系表 Mapper 接口
 * </p>
 *
 * @author zxl
 * @since 2019-03-01
 */
public interface SysDeptRelationMapper extends BaseMapper<SysDeptRelation> {
    /**
     * 删除部门关系表数据
     *
     * @param id 部门ID
     */
    void deleteDeptRelationsById(Integer id);

    /**
     * 更改部分关系表数据
     *
     * @param deptRelation
     */
    void updateDeptRelations(SysDeptRelation deptRelation);
}
