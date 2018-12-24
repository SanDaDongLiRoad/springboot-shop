package com.xulizhi.shop.service.impl;

import com.xulizhi.shop.domain.OrderGoodRelation;
import com.xulizhi.shop.repository.OrderGoodRelationRepository;
import com.xulizhi.shop.service.OrderGoodRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lenovo
 */
@Service
public class OrderGoodRelationServiceImpl implements OrderGoodRelationService {

    @Autowired
    private OrderGoodRelationRepository orderGoodRelationRepository;

    @Override
    public List<OrderGoodRelation> queryOrderGoodRelationByOrderId(String orderId) {
        return orderGoodRelationRepository.findByOrderId(orderId);
    }
}
