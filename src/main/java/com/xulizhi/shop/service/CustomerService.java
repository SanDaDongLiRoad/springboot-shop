package com.xulizhi.shop.service;

import com.xulizhi.shop.domain.Customer;

/**
 * @author lenovo
 */
public interface CustomerService {
    /**
     * 根据客户ID获取客户
     * @param id
     * @return
     */
    Customer getCustomerById(String id);
}
