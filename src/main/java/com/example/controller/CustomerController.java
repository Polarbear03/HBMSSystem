package com.example.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.bean.JsonResponse;
import com.example.model.dto.CustomerDto;
import com.example.model.entity.Admin;
import com.example.model.entity.Customer;
import com.example.service.inter.CustomerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/customer")
@Slf4j(topic = "Customer Operator")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @GetMapping("/listCustom")
    @Transactional(readOnly = true)
    public JsonResponse<List<Customer>> getAllCustomer(Customer customer) {
        QueryWrapper<Customer> customerQueryWrapper = null;
        boolean flag = false;
        if (customer != null) {
            customerQueryWrapper = new QueryWrapper<>(customer);
            flag = true;
        }
        if (flag) {
            return JsonResponse.success(customerService.list(customerQueryWrapper));
        }
        return JsonResponse.success(customerService.list());
    }

    @RequestMapping(value = "/removeCustom/{customerId}",method = RequestMethod.DELETE)
    public JsonResponse<String> removeCustom(@PathVariable Integer customerId) {
        boolean removeSuccess = customerService.removeById(customerId);
        if (removeSuccess) {
            return JsonResponse.success("删除顾客信息成功");
        }
        return JsonResponse.error("删除顾客信息失败，请稍后重试");
    }

    @PostMapping("/saveCustom")
    public JsonResponse<String> saveCustomer(Customer customer) {
        boolean saveSuccess = customerService.save(customer);
        if (saveSuccess) {
            return JsonResponse.success("顾客注册成功！");
        }
        return JsonResponse.error("注册失败，请稍后重试！");
    }

    @PostMapping("/updateCustom")
    public JsonResponse<String> updateCustomer(Customer customer) {
        boolean updateSuccess = customerService.updateById(customer);
        if (updateSuccess) {
            return JsonResponse.success("顾客信息更新成功!");
        }
        return JsonResponse.error("顾客信息更新失败，请稍后重试！");
    }

    @GetMapping("/getCusIds")
    @Transactional(readOnly = true)
    public JsonResponse<List<Customer>> getCusIds() {
        QueryWrapper<Customer> cusQueryWrapper = new QueryWrapper<>();
        cusQueryWrapper.select("customer_id");
        return JsonResponse.success(customerService.list(cusQueryWrapper));
    }

}
