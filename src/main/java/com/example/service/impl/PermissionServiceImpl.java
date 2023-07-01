package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.mapper.PermissionMapper;
import com.example.model.entity.Permission;
import com.example.service.inter.PermissionService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;
    @Override
    public List<String> queryPermissionByUserId(Integer userId) {
        return permissionMapper.queryPermissionByUserId(userId);
    }

    @Override
    public List<String> queryAllByPermissionDescriptionStrings() {
        return permissionMapper.queryAllByPermissionDescriptionStrings();
    }
}
