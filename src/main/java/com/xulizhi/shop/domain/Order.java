package com.xulizhi.shop.domain;

import com.xulizhi.shop.common.BaseDomain;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author lenovo
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_order")
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
