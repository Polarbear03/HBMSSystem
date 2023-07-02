package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.model.bean.JsonResponse;
import com.example.model.entity.Admin;
import com.example.model.entity.Customer;
import com.example.service.inter.CustomerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('/customer/**','customer:query')")
    @Transactional(readOnly = true)
    public JsonResponse<Page<Customer>> getAllCustomer(@RequestParam(value = "customerId",required = false) Integer customerId,
                                                       @RequestParam(value = "fullName",required = false) String fullName,
                                                       @RequestParam(value = "contact",required = false) String contact,
                                                       @RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                                       @RequestParam(value = "pageSize",defaultValue = "10") int pageSize
    ) {
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
        Page<Customer> page = new Page<>(pageNo,pageSize);
        if (flag) {
            customerService.page(page,customQueryWrapper);
            return JsonResponse.success(page);
        }
        customerService.page(page);
        return JsonResponse.success(page);
    }

    @RequestMapping(value = "/removeCustom/{customerId}",method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyAuthority('customer:delete','/customer/**')")
    public JsonResponse<String> removeCustom(@PathVariable Integer customerId) {
        boolean removeSuccess = customerService.removeById(customerId);
        if (removeSuccess) {
            return JsonResponse.success("删除顾客信息成功");
        }
        return JsonResponse.error("删除顾客信息失败，请稍后重试");
    }

    @PostMapping("/saveCustom")
    @PreAuthorize("hasAnyAuthority('customer:add','/customer/**')")
    public JsonResponse<String> saveCustomer(Customer customer) {
        boolean saveSuccess = customerService.save(customer);
        if (saveSuccess) {
            return JsonResponse.success("顾客注册成功！");
        }
        return JsonResponse.error("注册失败，请稍后重试！");
    }

    @PostMapping("/updateCustom")
    @PreAuthorize("hasAnyAuthority('customer:update','/customer/**')")
    public JsonResponse<String> updateCustomer(Customer customer) {
        boolean updateSuccess = customerService.updateById(customer);
        if (updateSuccess) {
            return JsonResponse.success("顾客信息更新成功!");
        }
        return JsonResponse.error("顾客信息更新失败，请稍后重试！");
    }

    @GetMapping("/getCusIds")
    @PreAuthorize("hasAnyAuthority('/customer/**','customer:query')")
    @Transactional(readOnly = true)
    public JsonResponse<List<Customer>> getCusIds() {
        QueryWrapper<Customer> cusQueryWrapper = new QueryWrapper<>();
        cusQueryWrapper.select("customer_id");
        return JsonResponse.success(customerService.list(cusQueryWrapper));
    }

}
