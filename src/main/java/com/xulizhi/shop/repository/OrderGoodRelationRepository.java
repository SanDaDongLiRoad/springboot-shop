package com.xulizhi.shop.repository;

import com.xulizhi.shop.domain.OrderGoodRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author lenovo
 */
public interface OrderGoodRelationRepository extends JpaRepository<OrderGoodRelation,String>{

    List<OrderGoodRelation> findByOrderId(String orderId);
}
