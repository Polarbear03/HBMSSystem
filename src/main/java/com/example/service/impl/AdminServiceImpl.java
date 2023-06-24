package com.example.service.impl;

import com.example.dao.mapper.AdminMapper;
import com.example.model.entity.Admin;
import com.example.model.entity.AdminExample;
import com.example.service.inter.AdminService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public long countByExample(AdminExample adminExample) {
        return adminMapper.countByExample(adminExample);
    }

    @Override
    public int deleteByExample(AdminExample adminExample) {
        return adminMapper.deleteByExample(adminExample);
    }

    @Override
    public int deleteByAdminId(Integer adminId) {
        return adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public int insertAdminPart(Admin admin) {
        return adminMapper.insertSelective(admin);
    }

    @Override
    public List<Admin> selectByExample(AdminExample adminExample) {
        return adminMapper.selectByExample(adminExample);
    }

    @Override
    public Admin selectByAdminId(Integer adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public int updateByExampleSelective(Admin row, AdminExample example) {
        return adminMapper.updateByExampleSelective(row,example);
    }

    @Override
    public int updateByExample(Admin row, AdminExample example) {
        return adminMapper.updateByExample(row,example);
    }

    @Override
    public int updateByAdminIdSelective(Admin admin) {
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public int updateByAdminId(Admin admin) {
        return adminMapper.updateByPrimaryKey(admin);
    }
}
