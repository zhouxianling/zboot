package com.zxl.sb.service;

import com.zxl.sb.dto.DeptDto;
import com.zxl.sb.dto.DeptTree;
import com.zxl.sb.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxl.sb.common.utils.R;

import java.util.List;

/**
 * <p>
 * 部门管理 服务类
 * </p>
 *
 * @author zxl
 * @since 2019-03-01
 */
public interface ISysDeptService extends IService<SysDept> {


    /**
     * 插入
     *
     * @param deptDto
     * @return
     */
    R saveDept(DeptDto deptDto);


    /**
     * 更新
     *
     * @param deptDto
     * @return
     */
    R updateDept(DeptDto deptDto);

    /**
     * 逻辑假删除
     *
     * @param id
     * @return
     */
    Boolean logicDeleteDeptById(Integer id);


    /**
     * 查询部门树菜单
     *
     * @return 树
     */
    List<DeptTree> selectTree();

    /**
     * 查询用户部门树
     *
     * @return 用户树
     */
    List<DeptTree> getUserTree();

}
