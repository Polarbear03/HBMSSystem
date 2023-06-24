package com.example.service.inter;

import com.example.model.entity.Installer;
import com.example.model.entity.InstallerExample;

import java.util.List;

public interface InstallerService {
    long countByExample(InstallerExample installerExample);

    int deleteByExample(InstallerExample installerExample);

    int insert(Installer installer);

    int insertSelective(Installer installer);

    List<Installer> selectByExample(InstallerExample installerExample);

    int updateByExampleSelective(Installer installer,InstallerExample installerExample);

    int updateByExample(Installer installer, InstallerExample installerExample);
}
