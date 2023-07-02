package com.example.service.inter;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.model.entity.User;

public interface UserService extends IService<User> {

    User getUserByUserName(String username);
    User getUserByUR(String username, Integer roleId);
}
