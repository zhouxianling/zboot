package com.zxl.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxl.demo.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zxl
 * @since 2019-02-14
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM `user`")
    List<User> getUserList();
}
