package com.xulizhi.shop.repository;

import com.xulizhi.shop.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lenovo
 */
public interface CustomerRepository extends JpaRepository<Customer,String> {
}
