package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.mapper.ProductCategoriesMapper;
import com.example.model.entity.ProductCategories;
import com.example.service.inter.ProductCategoriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductCategoriesServiceImpl extends ServiceImpl<ProductCategoriesMapper, ProductCategories> implements ProductCategoriesService {
}
