package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.mapper.ProductMapper;
import com.example.model.entity.Product;
import com.example.service.inter.ProductService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean save(Product entity) {
        return super.save(entity);
    }

    @Override
    public boolean saveOrUpdate(Product entity, Wrapper<Product> updateWrapper) {
        return super.saveOrUpdate(entity, updateWrapper);
    }


    @Override
    public boolean saveBatch(Collection<Product> entityList, int batchSize) {
        return super.saveBatch(entityList, batchSize);
    }


    @Override
    public List<Product> list(Wrapper<Product> queryWrapper) {
        return super.list(queryWrapper);
    }


    @Override
    public List<Product> list() {
        return super.list();
    }


    @Override
    public boolean updateById(Product entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    public boolean removeBatchByIds(Collection<?> list) {
        return super.removeBatchByIds(list);
    }
}
