package com.atguigu.dao;

import com.atguigu.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author 琉
 * @create 2021-10-22 19:56
 */
//这种指定必须在springboot启动类上注解指定在没用
@MapperScan
public interface UserMapper extends BaseMapper<User> {
}
