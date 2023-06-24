package com.example.service.inter;

import com.example.model.entity.Customer;
import com.example.model.entity.CustomerExample;

import java.util.List;

public interface CustomerService {
    long countByExample(CustomerExample customerExample);

    int deleteByExample(CustomerExample customerExample);

    int insert(Customer customer);

    int insertSelective(Customer customer);

    List<Customer> selectByExample(CustomerExample customerExample);

    int updateByExampleSelective(Customer customer,CustomerExample customerExample);

    int updateByExample(Customer customer, CustomerExample customerExample);
}
