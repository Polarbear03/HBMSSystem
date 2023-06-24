package com.example.service.inter;

import com.example.model.entity.ProductCategories;
import com.example.model.entity.ProductCategoriesExample;

import java.util.List;

public interface ProductCategoriesService {
    long countByExample(ProductCategoriesExample example);

    int deleteByExample(ProductCategoriesExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(ProductCategories row);

    int insertSelective(ProductCategories row);

    List<ProductCategories> selectByExampleWithBLOBs(ProductCategoriesExample example);

    List<ProductCategories> selectByExample(ProductCategoriesExample example);

    ProductCategories selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective( ProductCategories row, ProductCategoriesExample example);

    int updateByExampleWithBLOBs( ProductCategories row, ProductCategoriesExample example);

    int updateByExample( ProductCategories row,  ProductCategoriesExample example);

    int updateByPrimaryKeySelective(ProductCategories row);

    int updateByPrimaryKeyWithBLOBs(ProductCategories row);

    int updateByPrimaryKey(ProductCategories row);
}
