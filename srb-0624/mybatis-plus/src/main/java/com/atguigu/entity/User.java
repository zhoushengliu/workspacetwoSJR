package com.atguigu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author 琉
 * @create 2021-10-22 19:54
 */
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String email;
}