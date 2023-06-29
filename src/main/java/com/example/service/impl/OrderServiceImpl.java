package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.mapper.OrderMapper;
import com.example.model.entity.Order;
import com.example.service.inter.OrderService;

public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
