package com.example.controller;

import com.example.model.bean.JsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j(topic = "Login")
public class LoginController {

    @RequestMapping("/toLogin")
    public JsonResponse<String> login(@RequestParam(value = "username",required = true) String username,
                                      @RequestParam(value = "password",required = true) String password) {
        return null;
    }
}
