package com.example.service.impl;

import com.example.dao.mapper.CustomerMapper;
import com.example.model.entity.Customer;
import com.example.model.entity.CustomerExample;
import com.example.service.inter.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;
    @Override
    public long countByExample(CustomerExample customerExample) {
        return customerMapper.countByExample(customerExample);
    }

    @Override
    public int deleteByExample(CustomerExample customerExample) {
        return customerMapper.deleteByExample(customerExample);
    }

    @Override
    public int insert(Customer customer) {
        return customerMapper.insert(customer);
    }

    @Override
    public int insertSelective(Customer customer) {
        return customerMapper.insertSelective(customer);
    }

    @Override
    public List<Customer> selectByExample(CustomerExample customerExample) {
        return customerMapper.selectByExample(customerExample);
    }

    @Override
    public int updateByExampleSelective(Customer customer, CustomerExample customerExample) {
        return customerMapper.updateByExampleSelective(customer,customerExample);
    }

    @Override
    public int updateByExample(Customer customer, CustomerExample customerExample) {
        return customerMapper.updateByExample(customer,customerExample);
    }
}
