package com.example.service.impl;

import com.example.dao.mapper.OrderMapper;
import com.example.model.entity.Order;
import com.example.model.entity.OrderExample;
import com.example.service.inter.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Override
    public long countByExample(OrderExample example) {
        return orderMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderExample example) {
        return orderMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer orderid) {
        return orderMapper.deleteByPrimaryKey(orderid);
    }

    @Override
    public int insert(Order row) {
        return orderMapper.insert(row);
    }

    @Override
    public int insertSelective(Order row) {
        return orderMapper.insertSelective(row);
    }

    @Override
    public List<Order> selectByExample(OrderExample example) {
        return orderMapper.selectByExample(example);
    }

    @Override
    public Order selectByPrimaryKey(Integer orderid) {
        return orderMapper.selectByPrimaryKey(orderid);
    }

    @Override
    public int updateByExampleSelective(Order row, OrderExample example) {
        return orderMapper.updateByExampleSelective(row,example);
    }

    @Override
    public int updateByExample(Order row, OrderExample example) {
        return orderMapper.updateByExample(row,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Order row) {
        return orderMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(Order row) {
        return orderMapper.updateByPrimaryKey(row);
    }
}
