package com.example.service.inter;

import com.example.model.entity.Merchant;
import com.example.model.entity.MerchantExample;

import java.util.List;

public interface MerchantService {
    long countByExample(MerchantExample example);

    int deleteByExample(MerchantExample example);

    int insert(Merchant row);

    int insertSelective(Merchant row);

    List<Merchant> selectByExampleWithBLOBs(MerchantExample example);

    List<Merchant> selectByExample(MerchantExample example);

    int updateByExampleSelective(Merchant row, MerchantExample example);

    int updateByExampleWithBLOBs( Merchant row,  MerchantExample example);

    int updateByExample( Merchant row,  MerchantExample example);
}
