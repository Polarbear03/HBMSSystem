package com.example.service.impl;

import com.example.dao.mapper.OrderDetailMapper;
import com.example.model.entity.OrderDetail;
import com.example.model.entity.OrderDetailExample;
import com.example.service.inter.OrderDetailService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderDetailServiceImpl implements OrderDetailService {
    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Override
    public long countByExample(OrderDetailExample example) {
        return orderDetailMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderDetailExample example) {
        return orderDetailMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer orderDetailId) {
        return orderDetailMapper.deleteByPrimaryKey(orderDetailId);
    }

    @Override
    public int insert(OrderDetail row) {
        return orderDetailMapper.insert(row);
    }

    @Override
    public int insertSelective(OrderDetail row) {
        return orderDetailMapper.insertSelective(row);
    }

    @Override
    public List<OrderDetail> selectByExample(OrderDetailExample example) {
        return orderDetailMapper.selectByExample(example);
    }

    @Override
    public OrderDetail selectByPrimaryKey(Integer orderDetailId) {
        return orderDetailMapper.selectByPrimaryKey(orderDetailId);
    }

    @Override
    public int updateByExampleSelective(OrderDetail row, OrderDetailExample example) {
        return orderDetailMapper.updateByExampleSelective(row,example);
    }

    @Override
    public int updateByExample(OrderDetail row, OrderDetailExample example) {
        return orderDetailMapper.updateByExample(row, example);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderDetail row) {
        return orderDetailMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(OrderDetail row) {
        return orderDetailMapper.updateByPrimaryKey(row);
    }
}
