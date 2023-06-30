package com.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Admin;
import com.example.service.inter.AdminService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Slf4j(topic = "Admin Controller")
public class AdminController {
    @Resource
    private AdminService adminService;

    @GetMapping("/adminList")
    @Transactional(readOnly = true)
    public JsonResponse<List<Admin>> getAllAdmin(Admin admin) {
        QueryWrapper<Admin> adminQueryWrapper = null;
        boolean flag = false;
        if (admin != null) {
            adminQueryWrapper = new QueryWrapper<>(admin);
            flag = true;
        }
        if (flag) {
            return JsonResponse.success(adminService.list(adminQueryWrapper));
        }
        return JsonResponse.success(adminService.list());
    }

    @PostMapping("/modifyAdmin")
    public JsonResponse<String> updateAdmin(Admin admin) {
        boolean updateSuccess = adminService.updateById(admin);
        if (updateSuccess) {
            return JsonResponse.success("更新管理员信息成功！");
        }
        return JsonResponse.error("更新管理员信息失败，请稍后重试！");
    }

    @PostMapping("/save")
    public JsonResponse<String> saveAdmin(Admin admin) {
        boolean saveSuccess = adminService.save(admin);
        if (saveSuccess) {
            return JsonResponse.success("添加管理员信息成功！");
        }
        return JsonResponse.error("添加管理员信息失败，请稍后重试！");
    }

    @RequestMapping(value = "/removeAdmin/{adminId}",method = RequestMethod.DELETE)
    public JsonResponse<String> deleteAdmin(@PathVariable Integer adminId) {
        boolean removeSuccess = adminService.removeById(adminId);
        if (removeSuccess) {
            return JsonResponse.success("移除该管理员成功！");
        }
        return JsonResponse.error("移除该管理员时出现错误，请稍后重试！");
    }

    @GetMapping("/getAdminIds")
    @Transactional(readOnly = true)
    public JsonResponse<List<Admin>> getAdminIds() {
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        adminQueryWrapper.select("admin_id");
        return JsonResponse.success(adminService.list(adminQueryWrapper));
    }
}
