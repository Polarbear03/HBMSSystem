package com.example.service.impl;

import com.example.dao.mapper.ProductCategoriesMapper;
import com.example.model.entity.ProductCategories;
import com.example.model.entity.ProductCategoriesExample;
import com.example.service.inter.ProductCategoriesService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductCategoriesServiceImpl implements ProductCategoriesService {
    @Resource
    private ProductCategoriesMapper productCategoriesMapper;
    @Override
    public long countByExample(ProductCategoriesExample example) {
        return productCategoriesMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ProductCategoriesExample example) {
        return productCategoriesMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer categoryId) {
        return productCategoriesMapper.deleteByPrimaryKey(categoryId);
    }

    @Override
    public int insert(ProductCategories row) {
        return productCategoriesMapper.insert(row);
    }

    @Override
    public int insertSelective(ProductCategories row) {
        return productCategoriesMapper.insertSelective(row);
    }

    @Override
    public List<ProductCategories> selectByExampleWithBLOBs(ProductCategoriesExample example) {
        return productCategoriesMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<ProductCategories> selectByExample(ProductCategoriesExample example) {
        return productCategoriesMapper.selectByExample(example);
    }

    @Override
    public ProductCategories selectByPrimaryKey(Integer categoryId) {
        return productCategoriesMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public int updateByExampleSelective(ProductCategories row, ProductCategoriesExample example) {
        return productCategoriesMapper.updateByExampleSelective(row,example);
    }

    @Override
    public int updateByExampleWithBLOBs(ProductCategories row, ProductCategoriesExample example) {
        return productCategoriesMapper.updateByExampleWithBLOBs(row,example);
    }

    @Override
    public int updateByExample(ProductCategories row, ProductCategoriesExample example) {
        return productCategoriesMapper.updateByExample(row,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductCategories row) {
        return productCategoriesMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ProductCategories row) {
        return productCategoriesMapper.updateByPrimaryKeyWithBLOBs(row);
    }

    @Override
    public int updateByPrimaryKey(ProductCategories row) {
        return productCategoriesMapper.updateByPrimaryKey(row);
    }
}
