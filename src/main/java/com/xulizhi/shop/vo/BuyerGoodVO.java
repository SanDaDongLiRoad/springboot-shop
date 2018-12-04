package com.xulizhi.shop.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lenovo
 */
@Data
public class BuyerGoodVO {

    /**
     * 商品ID
     */
    private String id;

    /**
     * 商品名字
     */
    private String name;

    /**
     * 商品单价
     */
    private BigDecimal price;

    /**
     * 描述
     */
    private String description;

    /**
     * 商品图片
     */
    private String icon;
}
