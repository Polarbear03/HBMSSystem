package com.example.service.impl;

import com.example.dao.mapper.SystemMenuMapper;
import com.example.model.entity.SystemMenu;
import com.example.model.entity.SystemMenuExample;
import com.example.service.inter.SysMenuService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SystemMenuMapper systemMenuMapper;
    @Override
    public long countByExample(SystemMenuExample example) {
        return systemMenuMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SystemMenuExample example) {
        return systemMenuMapper 0;
    }

    @Override
    public int deleteByPrimaryKey(Long menuId) {
        return systemMenuMapper 0;
    }

    @Override
    public int insert(SystemMenu row) {
        return systemMenuMapper 0;
    }

    @Override
    public int insertSelective(SystemMenu row) {
        return systemMenuMapper 0;
    }

    @Override
    public List<SystemMenu> selectByExample(SystemMenuExample example) {
        return systemMenuMapper null;
    }

    @Override
    public SystemMenu selectByPrimaryKey(Long menuId) {
        return systemMenuMapper null;
    }

    @Override
    public int updateByExampleSelective(SystemMenu row, SystemMenuExample example) {
        return systemMenuMapper 0;
    }

    @Override
    public int updateByExample(SystemMenu row, SystemMenuExample example) {
        return systemMenuMapper 0;
    }

    @Override
    public int updateByPrimaryKeySelective(SystemMenu row) {
        return systemMenuMapper 0;
    }

    @Override
    public int updateByPrimaryKey(SystemMenu row) {
        return systemMenuMapper 0;
    }
}
