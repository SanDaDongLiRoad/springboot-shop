package com.xulizhi.shop.service.impl;

import com.xulizhi.shop.domain.Customer;
import com.xulizhi.shop.repository.CustomerRepository;
import com.xulizhi.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lenovo
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findOne(id);
    }
}
