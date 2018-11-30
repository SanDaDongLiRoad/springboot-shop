package com.xulizhi.shop.repository;

import com.xulizhi.shop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lenovo
 */
public interface OrderRepository extends JpaRepository<Order,String> {
}
