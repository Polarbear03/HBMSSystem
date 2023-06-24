package com.example.service.impl;

import com.example.dao.mapper.UserMapper;
import com.example.model.entity.User;
import com.example.model.entity.UserExample;
import com.example.service.inter.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public long countByExample(UserExample example) {
        return userMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserExample example) {
        return userMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String username) {
        return userMapper.deleteByPrimaryKey(username);
    }

    @Override
    public int insert(User row) {
        return userMapper.insert(row);
    }

    @Override
    public int insertSelective(User row) {
        return userMapper.insertSelective(row);
    }

    @Override
    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public User selectByPrimaryKey(String username) {
        return userMapper.selectByPrimaryKey(username);
    }

    @Override
    public int updateByExampleSelective(User row, UserExample example) {
        return userMapper.updateByExampleSelective(row,example);
    }

    @Override
    public int updateByExample(User row, UserExample example) {
        return userMapper.updateByExample(row,example);
    }

    @Override
    public int updateByPrimaryKeySelective(User row) {
        return userMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(User row) {
        return userMapper.updateByPrimaryKey(row);
    }
}
