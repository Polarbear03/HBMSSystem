package com.example.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.model.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {
    List<String> queryPermissionByUserId(@Param("userId") Integer userId);

    List<String> queryAllByPermissionDescriptionStrings();
}
