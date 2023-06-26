package com.example.controller;


import com.alibaba.fastjson2.JSON;
import com.example.model.entity.Admin;
import com.example.model.entity.AdminExample;
import com.example.service.inter.AdminService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Slf4j(topic = "Admin Controller")
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping("/getAllAdmin")
    public String getAdminByAdminId() {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        adminExample.setDistinct(false);
        adminExample.setOrderByClause("admin_id");
        List<Admin> admins = adminService.selectByExample(adminExample);
        return JSON.toJSONString(admins);
    }

}
