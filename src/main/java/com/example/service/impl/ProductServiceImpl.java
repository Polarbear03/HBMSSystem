package com.example.service.impl;

import com.example.dao.mapper.ProductMapper;
import com.example.model.entity.Product;
import com.example.model.entity.ProductExample;
import com.example.service.inter.ProductService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Override
    public long countByExample(ProductExample example) {
        return productMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ProductExample example) {
        return productMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer productid) {
        return productMapper.deleteByPrimaryKey(productid);
    }

    @Override
    public int insert(Product row) {
        return productMapper.insert(row);
    }

    @Override
    public int insertSelective(Product row) {
        return productMapper.insertSelective(row);
    }

    @Override
    public List<Product> selectByExample(ProductExample example) {
        return productMapper.selectByExample(example);
    }

    @Override
    public Product selectByPrimaryKey(Integer productid) {
        return productMapper.selectByPrimaryKey(productid);
    }

    @Override
    public int updateByExampleSelective(Product row, ProductExample example) {
        return productMapper.updateByExampleSelective(row,example);
    }

    @Override
    public int updateByExample(Product row, ProductExample example) {
        return productMapper.updateByExample(row,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Product row) {
        return productMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(Product row) {
        return productMapper.updateByPrimaryKey(row);
    }
}
