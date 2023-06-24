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
        return systemMenuMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long menuId) {
        return systemMenuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public int insert(SystemMenu row) {
        return systemMenuMapper.insert(row);
    }

    @Override
    public int insertSelective(SystemMenu row) {
        return systemMenuMapper.insertSelective(row);
    }

    @Override
    public List<SystemMenu> selectByExample(SystemMenuExample example) {
        return systemMenuMapper.selectByExample(example);
    }

    @Override
    public SystemMenu selectByPrimaryKey(Long menuId) {
        return systemMenuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int updateByExampleSelective(SystemMenu row, SystemMenuExample example) {
        return systemMenuMapper.updateByExampleSelective(row,example);
    }

    @Override
    public int updateByExample(SystemMenu row, SystemMenuExample example) {
        return systemMenuMapper.updateByExample(row,example);
    }

    @Override
    public int updateByPrimaryKeySelective(SystemMenu row) {
        return systemMenuMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(SystemMenu row) {
        return systemMenuMapper.updateByPrimaryKey(row);
    }
}
