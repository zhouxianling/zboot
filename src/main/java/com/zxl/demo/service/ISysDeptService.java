package com.zxl.demo.service;

import com.zxl.demo.dto.DeptDTO;
import com.zxl.demo.dto.DeptTree;
import com.zxl.demo.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * 插入或者更新
     *
     * @param deptDTO
     * @return
     */
    SysDept insertOrUpdate(DeptDTO deptDTO);

    /**
     * 逻辑假删除
     *
     * @param id
     * @return
     */
    Boolean logicDeleteDeptById(Long id);


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
