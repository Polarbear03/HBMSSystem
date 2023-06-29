package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.mapper.InstallerMapper;
import com.example.model.entity.Installer;
import com.example.service.inter.InstallerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InstallerServiceImpl extends ServiceImpl<InstallerMapper, Installer> implements InstallerService {
}
