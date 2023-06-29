package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Merchant;
import com.example.model.entity.Order;
import com.example.service.inter.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j(topic = "Order Operator")
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/listOrder")
    @Transactional(readOnly = true)
    public JsonResponse<List<Order>> getAllOrder(Order order) {
        QueryWrapper<Order> orderQueryWrapper = null;
        boolean flag = false;
        if (order != null) {
            orderQueryWrapper = new QueryWrapper<>(order);
            flag = true;
        }
        if (flag) {
            return JsonResponse.success(orderService.list(orderQueryWrapper));
        }
        return JsonResponse.success(orderService.list());
    }


    @PostMapping("/removeOrder")
    public JsonResponse<String> removeOrder(Order order) {
        boolean removeSuccess = orderService.removeById(order);
        if (removeSuccess) {
            return JsonResponse.success("删除订单信息成功");
        }
        return JsonResponse.error("删除订单信息失败，请稍后重试");
    }

    @PostMapping("/saveOrder")
    public JsonResponse<String> saveOrder(Order order) {
        boolean saveSuccess = orderService.save(order);
        if (saveSuccess) {
            return JsonResponse.success("删除订单信息！");
        }
        return JsonResponse.error("删除订单信息失败，请稍后重试！");
    }

    @PostMapping("/updateOrder")
    public JsonResponse<String> updateOrder(Order order) {
        boolean updateSuccess = orderService.updateById(order);
        if (updateSuccess) {
            return JsonResponse.success("订单信息更新成功!");
        }
        return JsonResponse.error("订单信息更新失败，请稍后重试！");
    }
}
