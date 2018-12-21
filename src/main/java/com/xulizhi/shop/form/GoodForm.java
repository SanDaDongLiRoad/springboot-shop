package com.xulizhi.shop.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lenovo
 */
@Data
public class GoodForm {

    /**
     * 商品id
     */
    private String id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片
     */
    private String icon;

    /**
     * 类目id
     */
    private String categoryId;
}
