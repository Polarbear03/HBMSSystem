package com.example.dao.mapper;

import com.example.model.entity.SystemMenu;
import com.example.model.entity.SystemMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemMenuMapper {
    long countByExample(SystemMenuExample example);

    int deleteByExample(SystemMenuExample example);

    int deleteByPrimaryKey(Long menuId);

    int insert(SystemMenu row);

    int insertSelective(SystemMenu row);

    List<SystemMenu> selectByExample(SystemMenuExample example);

    SystemMenu selectByPrimaryKey(Long menuId);

    int updateByExampleSelective(@Param("row") SystemMenu row, @Param("example") SystemMenuExample example);

    int updateByExample(@Param("row") SystemMenu row, @Param("example") SystemMenuExample example);

    int updateByPrimaryKeySelective(SystemMenu row);

    int updateByPrimaryKey(SystemMenu row);
}