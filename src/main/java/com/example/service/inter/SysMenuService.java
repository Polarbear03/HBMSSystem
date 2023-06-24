package com.example.service.inter;

import com.example.model.entity.SystemMenu;
import com.example.model.entity.SystemMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuService {
    long countByExample(SystemMenuExample example);

    int deleteByExample(SystemMenuExample example);

    int deleteByPrimaryKey(Long menuId);

    int insert(SystemMenu row);

    int insertSelective(SystemMenu row);

    List<SystemMenu> selectByExample(SystemMenuExample example);

    SystemMenu selectByPrimaryKey(Long menuId);

    int updateByExampleSelective(SystemMenu row, SystemMenuExample example);

    int updateByExample(SystemMenu row, SystemMenuExample example);

    int updateByPrimaryKeySelective(SystemMenu row);

    int updateByPrimaryKey(SystemMenu row);
}
