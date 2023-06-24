package com.example.controller;


import com.example.model.entity.AdminExample;
import com.example.service.inter.AdminService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Slf4j(topic = "Admin Controller")
public class AdminController {
    @Resource
    private AdminService adminService;

    AdminExample adminExample = new AdminExample();

}
