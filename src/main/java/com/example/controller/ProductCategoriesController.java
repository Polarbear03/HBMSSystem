package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Order;
import com.example.model.entity.ProductCategories;
import com.example.model.entity.ProductCategories;
import com.example.service.inter.ProductCategoriesService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producttype")
@Slf4j(topic = "Type Operator")
public class ProductCategoriesController {
    @Resource
    private ProductCategoriesService productCategoriesService;

    @GetMapping("/listPC")
    @Transactional(readOnly = true)
    public JsonResponse<List<ProductCategories>> getAllPC(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                                                          @RequestParam(value = "category_name",required = false) String categoryName,
                                                          @RequestParam(value = "description",required = false) String description) {
        QueryWrapper<ProductCategories> productCategoriesQueryWrapper  = new QueryWrapper<>();
        boolean flag = false;
        if (categoryId != null) {
            productCategoriesQueryWrapper.eq("category_id",categoryId);
            flag = true;
        }
        if (categoryName != null && !categoryName.isEmpty()) {
            productCategoriesQueryWrapper.likeLeft("category_name",categoryName);
        }
        if (description != null && !description.isEmpty()) {
            productCategoriesQueryWrapper.like("description",description);
        }
        if (flag) {
            return JsonResponse.success(productCategoriesService.list(productCategoriesQueryWrapper));
        }
        return JsonResponse.success(productCategoriesService.list());
    }


    @RequestMapping(value = "/removePC/{pcId}",method = RequestMethod.DELETE)
    public JsonResponse<String> removePC(@PathVariable Integer pcId) {
        boolean removeSuccess = productCategoriesService.removeById(pcId);
        if (removeSuccess) {
            return JsonResponse.success("商品分类信息删除成功");
        }
        return JsonResponse.error("商品分类信息删除失败，请稍后重试");
    }

    @PostMapping("/savePC")
    public JsonResponse<String> savePCer(ProductCategories ProductCategories) {
        boolean saveSuccess = productCategoriesService.save(ProductCategories);
        if (saveSuccess) {
            return JsonResponse.success("商品分类信息新增成功！");
        }
        return JsonResponse.error("商品分类信息新增失败，请稍后重试！");
    }

    @PostMapping("/updatePC")
    public JsonResponse<String> updatePCer(ProductCategories ProductCategories) {
        boolean updateSuccess = productCategoriesService.updateById(ProductCategories);
        if (updateSuccess) {
            return JsonResponse.success("商品分类信息更新成功!");
        }
        return JsonResponse.error("商品分类信息更新失败，请稍后重试！");
    }

    @GetMapping("/getPccIds")
    @Transactional(readOnly = true)
    public JsonResponse<List<ProductCategories>> getPccIds() {
        QueryWrapper<ProductCategories> pccQueryWrapper = new QueryWrapper<>();
        pccQueryWrapper.select("category_id");
        return JsonResponse.success(productCategoriesService.list(pccQueryWrapper));
    }

}
