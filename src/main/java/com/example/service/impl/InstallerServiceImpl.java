package com.example.service.impl;

import com.example.dao.mapper.InstallerMapper;
import com.example.model.entity.Installer;
import com.example.model.entity.InstallerExample;
import com.example.service.inter.InstallerService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstallerServiceImpl implements InstallerService {
    @Resource
    private InstallerMapper installerMapper;
    @Override
    public long countByExample(InstallerExample installerExample) {
        return installerMapper.countByExample(installerExample);
    }

    @Override
    public int deleteByExample(InstallerExample installerExample) {
        return installerMapper.deleteByExample(installerExample);
    }

    @Override
    public int insert(Installer installer) {
        return installerMapper.insert(installer);
    }

    @Override
    public int insertSelective(Installer installer) {
        return installerMapper.insertSelective(installer);
    }

    @Override
    public List<Installer> selectByExample(InstallerExample installerExample) {
        return installerMapper.selectByExample(installerExample);
    }

    @Override
    public int updateByExampleSelective(Installer installer, InstallerExample installerExample) {
        return installerMapper.updateByExampleSelective(installer,installerExample);
    }

    @Override
    public int updateByExample(Installer installer, InstallerExample installerExample) {
        return installerMapper.updateByExample(installer,installerExample);
    }
}
