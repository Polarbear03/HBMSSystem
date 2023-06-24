package com.example.service.inter;

import com.example.model.entity.OrderDetail;
import com.example.model.entity.OrderDetailExample;

import java.util.List;

public interface OrderDetailService {
    long countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(Integer orderDetailId);

    int insert(OrderDetail row);

    int insertSelective(OrderDetail row);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(Integer orderDetailId);

    int updateByExampleSelective( OrderDetail row,  OrderDetailExample example);

    int updateByExample( OrderDetail row,  OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail row);

    int updateByPrimaryKey(OrderDetail row);
}
