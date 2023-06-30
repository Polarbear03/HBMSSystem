package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Admin;
import com.example.model.entity.Customer;
import com.example.service.inter.CustomerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Slf4j(topic = "Customer Operator")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @GetMapping("/listCustom")
    @Transactional(readOnly = true)
    public JsonResponse<List<Customer>> getAllCustomer(@RequestParam(value = "customerId",required = false) Integer customerId,
                                                       @RequestParam(value = "fullName",required = false) String fullName,
                                                       @RequestParam(value = "contact",required = false) String contact) {
        QueryWrapper<Customer> customQueryWrapper = new QueryWrapper<>();
        boolean flag = false;
        if (customerId != null) {
            customQueryWrapper.eq("customer_id",customerId);
            flag = true;
        }
        if (fullName != null && !fullName.isEmpty()) {
            customQueryWrapper.likeLeft("full_name",fullName);
            flag = true;
        }
        if (contact != null && !contact.isEmpty()) {
            customQueryWrapper.likeLeft("contact",contact);
            flag = true;
        }
        if (flag) {
            return JsonResponse.success(customerService.list(customQueryWrapper));
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
