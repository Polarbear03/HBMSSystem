package com.example.controller;

import com.example.service.inter.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginController {

    @Resource
    private UserService userService;

    @Resource
    private ObjectMapper objectMapper;


}

