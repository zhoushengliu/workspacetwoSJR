package com.atguigu.service.impl;

import com.atguigu.dao.UserMapper;
import com.atguigu.entity.User;
import com.atguigu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 琉
 * @create 2021-10-22 21:07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
