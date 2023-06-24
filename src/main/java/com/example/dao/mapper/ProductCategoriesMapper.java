package com.example.dao.mapper;

import com.example.model.entity.ProductCategories;
import com.example.model.entity.ProductCategoriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductCategoriesMapper {
    long countByExample(ProductCategoriesExample example);

    int deleteByExample(ProductCategoriesExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(ProductCategories row);

    int insertSelective(ProductCategories row);

    List<ProductCategories> selectByExampleWithBLOBs(ProductCategoriesExample example);

    List<ProductCategories> selectByExample(ProductCategoriesExample example);

    ProductCategories selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("row") ProductCategories row, @Param("example") ProductCategoriesExample example);

    int updateByExampleWithBLOBs(@Param("row") ProductCategories row, @Param("example") ProductCategoriesExample example);

    int updateByExample(@Param("row") ProductCategories row, @Param("example") ProductCategoriesExample example);

    int updateByPrimaryKeySelective(ProductCategories row);

    int updateByPrimaryKeyWithBLOBs(ProductCategories row);

    int updateByPrimaryKey(ProductCategories row);
}