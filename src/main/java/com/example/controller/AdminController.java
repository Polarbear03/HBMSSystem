package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Admin;
import com.example.model.group.AddGroup;
import com.example.model.group.EditGroup;
import com.example.service.inter.AdminService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Slf4j(topic = "Admin Controller")
public class AdminController {
    @Resource
    private AdminService adminService;

    @GetMapping("/adminList")
    @PreAuthorize("hasAnyAuthority('admin:query','/admin/**')")
    @Transactional(readOnly = true)
    public JsonResponse<List<Admin>> getAllAdmin(@RequestParam(value = "adminId", required = false) Integer adminId,
                                                 @RequestParam(value = "fullName", required = false) String fullName,
                                                 @RequestParam(value = "contact", required = false) String contact) {
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        boolean flag = false;
        if (adminId != null) {
            adminQueryWrapper.eq("admin_id", adminId);
            flag = true;
        }
        if (fullName != null && !fullName.isEmpty()) {
            adminQueryWrapper.likeLeft("full_name", fullName);
            flag = true;
        }
        if (contact != null && !contact.isEmpty()) {
            adminQueryWrapper.likeLeft("contact", contact);
            flag = true;
        }
        if (flag) {
            return JsonResponse.success(adminService.list(adminQueryWrapper));
        }
        return JsonResponse.success(adminService.list());
    }

    @PostMapping("/modifyAdmin")
    @PreAuthorize("hasAnyAuthority('admin:update','/admin/**')")
    public JsonResponse<String> updateAdmin(@Validated(EditGroup.class) @RequestBody Admin admin) {
        boolean updateSuccess = adminService.updateById(admin);
        if (updateSuccess) {
            return JsonResponse.success("更新管理员信息成功！");
        }
        return JsonResponse.error("更新管理员信息失败，请稍后重试！");
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('admin:add','/admin/**')")
    public JsonResponse<String> saveAdmin(@Validated(AddGroup.class) @RequestBody Admin admin) {
        boolean saveSuccess = adminService.save(admin);
        if (saveSuccess) {
            return JsonResponse.success("添加管理员信息成功！");
        }
        return JsonResponse.error("添加管理员信息失败，请稍后重试！");
    }

    @RequestMapping(value = "/removeAdmin/{adminId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyAuthority('admin:delete','/admin/**')")
    public JsonResponse<String> deleteAdmin(@PathVariable Integer adminId) {
        boolean removeSuccess = adminService.removeById(adminId);
        if (removeSuccess) {
            return JsonResponse.success("移除该管理员成功！");
        }
        return JsonResponse.error("移除该管理员时出现错误，请稍后重试！");
    }

    @GetMapping("/getAdminIds")
    @PreAuthorize("hasAnyAuthority('admin:query','/admin/**')")
    @Transactional(readOnly = true)
    public JsonResponse<List<Admin>> getAdminIds() {
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        adminQueryWrapper.select("admin_id");
        return JsonResponse.success(adminService.list(adminQueryWrapper));
    }
}
