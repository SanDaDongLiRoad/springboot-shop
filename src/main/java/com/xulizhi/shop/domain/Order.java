package com.xulizhi.shop.domain;

import com.xulizhi.shop.common.BaseDomain;
import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author lenovo
 */
@Data
@Entity
public class Order extends BaseDomain{

    private static final long serialVersionUID = -2284612546640923998L;
    /**
     * 订单总额
     */
    private BigDecimal amount;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 客户ID
     */
    private String customerId;
}
