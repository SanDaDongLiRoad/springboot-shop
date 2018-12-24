package com.xulizhi.shop.domain;

import com.xulizhi.shop.common.BaseDomain;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author lenovo
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_order_good_relation")
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
    private Integer quantity;
}
