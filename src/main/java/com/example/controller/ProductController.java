package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Product;
import com.example.service.inter.ProductService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@Slf4j(topic = "Product Operator")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping({"/list", "/findProduct"})
    @PreAuthorize("hasAnyAuthority('/product/**','product:query')")
    @Transactional(readOnly = true)
    public JsonResponse<List<Product>> getAllProduct(@RequestParam(value = "productId", required = false) Integer productId,
                                                     @RequestParam(value = "productName", required = false) String productName,
                                                     @RequestParam(value = "description", required = false) String description) {
        QueryWrapper<Product> proQueryWrapper = new QueryWrapper<>();
        boolean flag = false;
        if (productId != null) {
            proQueryWrapper.eq("product_id", productId);
            flag = true;
        }
        if (productName != null && !productName.isEmpty()) {
            proQueryWrapper.likeLeft("product_name", productName);
            flag = true;
        }
        if (description != null && !description.isEmpty()) {
            proQueryWrapper.like("description", description);
            flag = true;
        }
        if (flag) {
            return JsonResponse.success(productService.list(proQueryWrapper));
        }
        return JsonResponse.success(productService.list());
    }

    @PostMapping("/modifyProduct")
    @PreAuthorize("hasAnyAuthority('/product/**','product:update')")
    public JsonResponse<String> updateProduct(@RequestBody Product product) {
        boolean updateSuccess = productService.updateById(product);
        if (updateSuccess) {
            return JsonResponse.success("更新商品信息成功！");
        }
        return JsonResponse.error("更新商品信息失败，请检查填写信息是否有误！");
    }

    @PostMapping("/saveProduct")
    @PreAuthorize("hasAnyAuthority('/product/**','product:add')")
    public JsonResponse<String> saveProduct(@RequestBody Product product) {
        boolean saveSuccess = productService.save(product);
        if (saveSuccess) {
            return JsonResponse.success("商品信息保存成功");
        }
        return JsonResponse.error("商品信息保存出错");
    }

    @RequestMapping(value = "/removeProduct/{proId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyAuthority('/product/**','product:delete')")
    public JsonResponse<String> deleteProduct(@PathVariable Integer proId) {
        boolean removeSuccess = productService.removeById(proId);
        if (removeSuccess) {
            return JsonResponse.success("移除该商品成功！");
        }
        return JsonResponse.error("移除该商品时出现错误，请稍后重试！");
    }

    @GetMapping("/getProIds")
    @PreAuthorize("hasAnyAuthority('/product/**','product:query')")
    @Transactional(readOnly = true)
    public JsonResponse<List<Product>> getProIds() {
        QueryWrapper<Product> proQueryWrapper = new QueryWrapper<>();
        proQueryWrapper.select("product_id");
        return JsonResponse.success(productService.list(proQueryWrapper));
    }

}
