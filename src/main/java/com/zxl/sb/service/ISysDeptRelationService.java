package com.zxl.sb.service;

import com.zxl.sb.entity.SysDept;
import com.zxl.sb.entity.SysDeptRelation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 部门关系表 服务类
 * </p>
 *
 * @author zxl
 * @since 2019-03-01
 */
public interface ISysDeptRelationService extends IService<SysDeptRelation> {
    /**
     * 新建部门关系
     *
     * @param sysDept 部门
     */
    void insertDeptRelation(SysDept sysDept);

    /**
     * 通过ID删除部门关系
     *
     * @param id
     */
    void deleteAllDeptRelation(Integer id);


}
