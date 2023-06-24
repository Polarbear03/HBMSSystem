package com.example.service.impl;

import com.example.dao.mapper.MerchantMapper;
import com.example.model.entity.Merchant;
import com.example.model.entity.MerchantExample;
import com.example.service.inter.MerchantService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Resource
    private MerchantMapper merchantMapper;
    @Override
    public long countByExample(MerchantExample example) {
        return merchantMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MerchantExample example) {
        return merchantMapper.deleteByExample(example);
    }

    @Override
    public int insert(Merchant row) {
        return merchantMapper.insert(row);
    }

    @Override
    public int insertSelective(Merchant row) {
        return merchantMapper.insertSelective(row);
    }

    @Override
    public List<Merchant> selectByExampleWithBLOBs(MerchantExample example) {
        return merchantMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Merchant> selectByExample(MerchantExample example) {
        return merchantMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(Merchant row, MerchantExample example) {
        return merchantMapper.updateByExampleSelective(row,example);
    }

    @Override
    public int updateByExampleWithBLOBs(Merchant row, MerchantExample example) {
        return merchantMapper.updateByExampleWithBLOBs(row,example);
    }

    @Override
    public int updateByExample(Merchant row, MerchantExample example) {
        return merchantMapper.updateByExample(row,example);
    }
}
