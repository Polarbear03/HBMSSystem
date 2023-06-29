package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.mapper.ProductMapper;
import com.example.model.entity.Product;
import com.example.service.inter.ProductService;
import com.sun.tools.javac.util.List;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private RedisTemplate redisTemplate;

    public List<Product> getAllProduct(Wrapper<Product> productWrapper) {
        return (List<Product>) productMapper.selectList(productWrapper);
    }
}
