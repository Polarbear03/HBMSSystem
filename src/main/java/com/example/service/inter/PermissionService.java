package com.example.service.inter;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.model.entity.Permission;

import java.util.List;

public interface PermissionService extends IService<Permission> {
    List<String> queryPermissionByUserId(Integer userId);

    List<String> queryAllByPermissionDescriptionStrings();
}
