package com.example.controller;

import com.alibaba.fastjson2.JSON;
import com.example.model.entity.User;
import com.example.model.entity.UserExample;
import com.example.service.inter.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j(topic = "User Operator")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/adminLogin")
    public String adminLogin(@RequestParam(value = "adminLoginName",required = true) String username,
                             @RequestParam(value = "adminLoginPwd",required = true) String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<User> users = userService.selectByExample(userExample);
        if (users.isEmpty() && users.size() == 0) {
            return JSON.toJSONString("该用户尚未注册");
        }
        return JSON.toJSONString("用户登录成功");
    }
}
