package com.example.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Product;
import com.example.service.inter.ProductService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/goods")
@Slf4j(topic = "Product Operator")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping({"/list","/findProduct"})
    @Transactional(readOnly = true)
    public JsonResponse<List<Product>> getAllProduct(@RequestParam(value = "productId",required = false) Integer productId,
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
            return JsonResponse.success(productService.list(objectQueryWrapper));
        }
        return JsonResponse.success(productService.list());
    }

    @PostMapping("/modifyProduct")
    public String updateProduct(Product product) {
        boolean updateSuccess = productService.updateById(product);
        if (updateSuccess) {
            return JSON.toJSONString("更新商品信息成功！");
        }
        return JSON.toJSONString("更新商品信息失败，请检查填写信息是否有误！");
    }

    @PostMapping("/saveProduct")
    public JsonResponse<String> saveProduct(Product product) {
        boolean saveSuccess = productService.save(product);
        if (saveSuccess) {
            return JsonResponse.success("商品信息保存成功");
        }
        return JsonResponse.error("商品信息保存出错");
    }

    @PostMapping("/removeProduct")
    public String deleteProduct(@RequestParam(value = "productId",required = true)Integer[] productId) {
        boolean removeSuccess = false;
        if (productId.length == 1) {
            removeSuccess = productService.removeById(productId);
        } else {
            List<Integer> productIds = Arrays.asList(productId);
            removeSuccess = productService.removeBatchByIds(productIds);

        }
        if (removeSuccess) {
            return JSON.toJSONString("删除该商品成功!");
        }
        return JSON.toJSONString("删除该商品时出现错误，请稍候重试！");
    }


}
