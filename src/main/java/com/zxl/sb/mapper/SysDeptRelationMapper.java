package com.zxl.sb.mapper;

import com.zxl.sb.entity.SysDeptRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    @Select("DELETE FROM sys_dept_relation WHERE descendant IN (SELECT temp.descendant FROM (SELECT descendant FROM sys_dept_relation WHERE ancestor = #{id}) temp)")
    void deleteDeptRelationsById(@Param("id") Integer id);

}
