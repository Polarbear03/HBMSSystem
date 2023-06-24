package com.example.service.inter;

import com.example.model.entity.Product;
import com.example.model.entity.ProductExample;

import java.util.List;

public interface ProductService {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer productid);

    int insert(Product row);

    int insertSelective(Product row);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer productid);

    int updateByExampleSelective(Product row,  ProductExample example);

    int updateByExample(Product row, ProductExample example);

    int updateByPrimaryKeySelective(Product row);

    int updateByPrimaryKey(Product row);
}
