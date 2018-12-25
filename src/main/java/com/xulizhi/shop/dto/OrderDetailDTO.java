package com.xulizhi.shop.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lenovo
 */
@Data
public class OrderDetailDTO {

    /**
     * 商品ID
     */
    private String goodId;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 商品单价
     */
    private BigDecimal price;

    /**
     * 商品数量
     */
    private Integer quantity;

    /**
     * 商品总额
     */
    private BigDecimal amount;

}
