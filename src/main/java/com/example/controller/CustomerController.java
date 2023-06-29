package com.example.controller;

import com.alibaba.fastjson2.JSON;
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

    //@Resource
    //private CustomerService customerService;
    //
    //@GetMapping({"/getAllCustomer","/findCustomer"})
    //@Transactional(readOnly = true)
    //public List<Customer> getAllCustomer(@RequestParam(value = "customerId",required = false) Integer customerId,
    //                               @RequestParam(value = "fullName",required = false) String fullName,
    //                               @RequestParam(value = "contact",required = false) String contact,
    //                               @RequestParam(value = "email",required = false) String email,
    //                               @RequestParam(value = "gender",required = false) String gender,
    //                               @RequestParam(value = "address",required = false) String address) {
    //    CustomerExample customerExample = new CustomerExample();
    //    CustomerExample.Criteria criteria = customerExample.createCriteria();
    //    if (customerId != null) {
    //        criteria.andCustomerIdEqualTo(customerId);
    //    }
    //    if (fullName != null) {
    //        criteria.andFullNameLike(fullName);
    //    }
    //    if (contact != null) {
    //        criteria.andContactEqualTo(contact);
    //    }
    //    if (email != null) {
    //        criteria.andEmailEqualTo(email);
    //    }
    //    if (gender != null) {
    //        criteria.andGenderEqualTo(gender);
    //    }
    //    if (address != null) {
    //        criteria.andAddressLike(address);
    //    }
    //    customerExample.setDistinct(false);
    //    customerExample.setOrderByClause("customer_id");
    //    return customerService.selectByExample(customerExample);
    //}
    //
    //@PostMapping("/addCustomerInfo")
    //public String insertAdmin(Customer customer) {
    //    customerService.insert(customer);
    //    return JSON.toJSONString("新增顾客成功!");
    //}
    //
    //@PostMapping("/updateCustomerInfo")
    //public String updateAdmin(Customer customer) {
    //    customerService.updateByExample(customer,null);
    //    return JSON.toJSONString("修改顾客信息成功！");
    //}
    //
    //@PostMapping("/deleteCustomerInfo")
    //public String deleteAdmin(@RequestParam(value = "customerId",required = false) Integer[] customerId) {
    //    CustomerExample customerExample = new CustomerExample();
    //    CustomerExample.Criteria criteria = customerExample.createCriteria();
    //    if (customerId.length == 1) {
    //        criteria.andCustomerIdEqualTo(customerId[0]);
    //    } else {
    //        List<Integer> customers = Arrays.asList(customerId);
    //        criteria.andCustomerIdIn(customers);
    //    }
    //    customerService.deleteByExample(customerExample);
    //    return JSON.toJSONString("删除顾客信息成功！");
    //
    //}

}
