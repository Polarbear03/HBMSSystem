package com.example.service.inter;

import com.example.model.entity.Order;
import com.example.model.entity.OrderExample;

import java.util.List;

public interface OrderService {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(Order row);

    int insertSelective(Order row);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective( Order row, OrderExample example);

    int updateByExample( Order row, OrderExample example);

    int updateByPrimaryKeySelective(Order row);

    int updateByPrimaryKey(Order row);
}
