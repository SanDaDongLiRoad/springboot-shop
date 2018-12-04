package com.xulizhi.shop.vo;

import lombok.Data;

import java.util.List;

/**
 * @author lenovo
 */
@Data
public class BuyerGoodListVO {

    /**
     * 类目ID
     */
    private String id;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类目下的商品列表
     */
    private List<BuyerGoodVO>  buyerGoods;
}
