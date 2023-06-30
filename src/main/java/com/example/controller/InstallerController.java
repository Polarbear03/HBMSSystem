package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Customer;
import com.example.model.entity.Installer;
import com.example.service.inter.InstallerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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
    @Transactional(readOnly = true)
    public JsonResponse<List<Installer>> getAllInstaller(Installer installer) {
        QueryWrapper<Installer> installerQueryWrapper = null;
        boolean flag = false;
        if (installer != null) {
            installerQueryWrapper = new QueryWrapper<>(installer);
            flag = true;
        }
        if (flag) {
            return JsonResponse.success(installerService.list(installerQueryWrapper));
        }
        return JsonResponse.success(installerService.list());
    }

    @RequestMapping(value = "/removeIns/{installerId}",method = RequestMethod.DELETE)
    public JsonResponse<String> removeInstaller(@PathVariable Integer installerId) {
        boolean removeSuccess = installerService.removeById(installerId);
        if (removeSuccess) {
            return JsonResponse.success("删除安装员信息成功");
        }
        return JsonResponse.error("删除安装员信息失败，请稍后重试");
    }

    @PostMapping("/saveIns")
    public JsonResponse<String> saveInstaller(Installer installer) {
        boolean saveSuccess = installerService.save(installer);
        if (saveSuccess) {
            return JsonResponse.success("安装员注册成功！");
        }
        return JsonResponse.error("安装员注册失败，请稍后重试！");
    }

    @PostMapping("/updateIns")
    public JsonResponse<String> updateInstaller(Installer installer) {
        boolean updateSuccess = installerService.updateById(installer);
        if (updateSuccess) {
            return JsonResponse.success("安装员信息更新成功!");
        }
        return JsonResponse.error("安装员信息更新失败，请稍后重试！");
    }

}
