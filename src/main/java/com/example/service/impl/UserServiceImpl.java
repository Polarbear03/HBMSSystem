package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.mapper.UserMapper;
import com.example.model.entity.User;
import com.example.service.inter.UserService;

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
