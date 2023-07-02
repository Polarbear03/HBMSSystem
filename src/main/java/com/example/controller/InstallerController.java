package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Admin;
import com.example.model.entity.Customer;
import com.example.model.entity.Installer;
import com.example.model.entity.Merchant;
import com.example.service.inter.InstallerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/installer")
@Slf4j(topic = "Installer Operator")
public class InstallerController {
    @Resource
    private InstallerService installerService;

    @GetMapping("/listIns")
    @PreAuthorize("hasAnyAuthority('/installer/**','installer:query')")
    @Transactional(readOnly = true)
    public JsonResponse<Page<Installer>> getAllInstaller(@RequestParam(value = "installerId", required = false) Integer installerId,
                                                         @RequestParam(value = "fullName", required = false) String fullName,
                                                         @RequestParam(value = "contact", required = false) String contact,
                                                         @RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {

        QueryWrapper<Installer> installerQueryWrapper = new QueryWrapper<>();
        boolean flag = false;
        if (installerId != null) {
            installerQueryWrapper.eq("installer_id", installerId);
            flag = true;
        }
        if (fullName != null && !fullName.isEmpty()) {
            installerQueryWrapper.likeLeft("full_name", fullName);
            flag = true;
        }
        if (contact != null && !contact.isEmpty()) {
            installerQueryWrapper.likeLeft("contact", contact);
            flag = true;
        }
        Page<Installer> page = new Page<>(pageNo,pageSize);
        if (flag) {
            installerService.page(page,installerQueryWrapper);
            return JsonResponse.success(page);
        }
        installerService.page(page);
        return JsonResponse.success(page);
    }

    @RequestMapping(value = "/removeIns/{installerId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyAuthority('/installer/**','installer:delete')")
    public JsonResponse<String> removeInstaller(@PathVariable Integer installerId) {
        boolean removeSuccess = installerService.removeById(installerId);
        if (removeSuccess) {
            return JsonResponse.success("删除安装员信息成功");
        }
        return JsonResponse.error("删除安装员信息失败，请稍后重试");
    }

    @PostMapping("/saveIns")
    @PreAuthorize("hasAnyAuthority('/installer/**','installer:add')")
    public JsonResponse<String> saveInstaller(Installer installer) {
        boolean saveSuccess = installerService.save(installer);
        if (saveSuccess) {
            return JsonResponse.success("安装员注册成功！");
        }
        return JsonResponse.error("安装员注册失败，请稍后重试！");
    }

    @PostMapping("/updateIns")
    @PreAuthorize("hasAnyAuthority('/installer/**','installer:update')")
    public JsonResponse<String> updateInstaller(Installer installer) {
        boolean updateSuccess = installerService.updateById(installer);
        if (updateSuccess) {
            return JsonResponse.success("安装员信息更新成功!");
        }
        return JsonResponse.error("安装员信息更新失败，请稍后重试！");
    }


    @GetMapping("/getInsIds")
    @PreAuthorize("hasAnyAuthority('/installer/**','installer:query')")
    @Transactional(readOnly = true)
    public JsonResponse<List<Installer>> getInsIds() {
        QueryWrapper<Installer> insQueryWrapper = new QueryWrapper<>();
        insQueryWrapper.select("installer_id");
        return JsonResponse.success(installerService.list(insQueryWrapper));
    }

}
