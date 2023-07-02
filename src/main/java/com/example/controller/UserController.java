package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Task;
import com.example.model.entity.User;
import com.example.service.inter.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j(topic = "User Operator")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getUsrIds")
    @Transactional(readOnly = true)
    public JsonResponse<List<User>> getUsrIds() {
        QueryWrapper<User> usrQueryWrapper = new QueryWrapper<>();
        usrQueryWrapper.select("user_id");
        return JsonResponse.success(userService.list(usrQueryWrapper));
    }


    @PostMapping({"/register","/addUser"})
    public JsonResponse<String> saveUser(@RequestBody User user) {
        boolean saveSuccess = userService.save(user);
        if (saveSuccess) {
            return JsonResponse.success("添加用户成功");
        }
        return JsonResponse.error("添加用户失败，请稍后重试");
    }




}
