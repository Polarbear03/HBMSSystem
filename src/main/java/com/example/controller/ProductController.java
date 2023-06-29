package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.entity.Product;
import com.example.model.vo.ProductVO;
import com.example.service.inter.ProductService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.List;

@RestController
@RequestMapping("/goods/goods")
@Slf4j(topic = "Product Operator")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping({"/getProducts","/findProduct"})
    @Transactional(readOnly = true)
    public List<Product> getAllProduct(@RequestParam(value = "productId",required = false) Integer productId,
                                       @RequestParam(value = "productName",required = false) String productName,
                                       @RequestParam(value = "price",required = false) Double price,
                                       @RequestParam(value = "stock",required = false) Integer stock) {
        QueryWrapper<Product> objectQueryWrapper = new QueryWrapper<>();
        boolean flag = false;
        if (productId != null) {
            objectQueryWrapper.eq("product_id",productId);
            flag = true;
        }
        if (productName != null) {
            objectQueryWrapper.likeLeft("product_name", productName);
            flag = true;
        }
        if (price != null && !price.isNaN()) {
            objectQueryWrapper.eq("price",price);
            flag = true;
        }
        if (stock != null) {
            objectQueryWrapper.eq("stock",stock);
            flag = true;
        }
        if (flag) {
            return productService.list(objectQueryWrapper);
        }
        return productService.list();
    }



}
