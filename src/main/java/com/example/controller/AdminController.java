package com.example.controller;


import com.alibaba.fastjson2.JSON;
import com.example.model.entity.Admin;
import com.example.model.entity.AdminExample;
import com.example.service.inter.AdminService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
@Slf4j(topic = "Admin Controller")
public class AdminController {
    @Resource
    private AdminService adminService;

    @GetMapping({"/getAllAdmin","/findAdmin"})
    @Transactional(readOnly = true)
    public List<Admin> getAllAdmin(@RequestParam(value = "adminId",required = false) Integer adminId,
                              @RequestParam(value = "fullName",required = false) String fullName,
                              @RequestParam(value = "contact",required = false) String contact,
                              @RequestParam(value = "email",required = false) String email) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        if (adminId != null) {
            criteria.andAdminIdEqualTo(adminId);
        }
        if (fullName != null && !fullName.isEmpty()) {
            criteria.andFullNameLike(fullName);
        }
        if (contact != null && !contact.isEmpty()) {
            criteria.andContactLike(contact);
        }
        if (email != null && !email.isEmpty()) {
            criteria.andEmailLike(email);
        }
        adminExample.setDistinct(false);
        adminExample.setOrderByClause("admin_id");
        return adminService.selectByExample(adminExample);
    }

    @PostMapping("/addAdminInfo")
    public String insertAdmin(Admin admin) {
        adminService.insertAdmin(admin);
        return JSON.toJSONString("新增管理员成功!");
    }

    @PostMapping("/updateAdminInfo")
    public String updateAdmin(Admin admin) {
        adminService.updateByAdminId(admin);
        return JSON.toJSONString("修改该管理员信息成功！");
    }

    @PostMapping("/deleteAdminInfo")
    public String deleteAdmin(@RequestParam(value = "adminId",required = false) Integer[] adminId) {
        AdminExample adminExample  = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        if (adminId.length == 1) {
            adminService.deleteByAdminId(adminId[0]);
        } else {
            List<Integer> admins = Arrays.asList(adminId);
            criteria.andAdminIdIn(admins);
            adminService.deleteByExample(adminExample);
        }
        return JSON.toJSONString("删除管理员信息成功！");
    }
}
