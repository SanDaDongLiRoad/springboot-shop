package com.xulizhi.shop.service;

import com.xulizhi.shop.domain.OrderGoodRelation;

import java.util.List;

/**
 * @author lenovo
 */
public interface OrderGoodRelationService {

    /**
     * 查询同意订单下的订单商品关系列表
     * @param orderId
     * @return
     */
    List<OrderGoodRelation> queryOrderGoodRelationByOrderId(String orderId);
}
