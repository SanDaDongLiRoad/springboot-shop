package com.xulizhi.shop.domain;

import com.xulizhi.shop.common.BaseDomain;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author lenovo
 */
@Data
@Entity
public class OrderGoodRelation extends BaseDomain{
    private static final long serialVersionUID = 3079813580090790713L;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 商品ID
     */
    private String goodId;

    /**
     * 商品数量
     */
    private String quantity;
}
