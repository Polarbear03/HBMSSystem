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

}
