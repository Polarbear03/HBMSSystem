package com.example.dao.mapper;

import com.example.model.entity.Merchant;
import com.example.model.entity.MerchantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantMapper {
    long countByExample(MerchantExample example);

    int deleteByExample(MerchantExample example);

    int insert(Merchant row);

    int insertSelective(Merchant row);

    List<Merchant> selectByExampleWithBLOBs(MerchantExample example);

    List<Merchant> selectByExample(MerchantExample example);

    int updateByExampleSelective(@Param("row") Merchant row, @Param("example") MerchantExample example);

    int updateByExampleWithBLOBs(@Param("row") Merchant row, @Param("example") MerchantExample example);

    int updateByExample(@Param("row") Merchant row, @Param("example") MerchantExample example);
}