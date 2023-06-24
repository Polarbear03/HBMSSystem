package com.example.dao.mapper;

import com.example.model.entity.Installer;
import com.example.model.entity.InstallerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InstallerMapper {
    long countByExample(InstallerExample example);

    int deleteByExample(InstallerExample example);

    int insert(Installer row);

    int insertSelective(Installer row);

    List<Installer> selectByExample(InstallerExample example);

    int updateByExampleSelective(@Param("row") Installer row, @Param("example") InstallerExample example);

    int updateByExample(@Param("row") Installer row, @Param("example") InstallerExample example);
}