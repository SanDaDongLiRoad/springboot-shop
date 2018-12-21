package com.xulizhi.shop.enums;

import lombok.Getter;

/**
 * @author lenovo
 */
@Getter
public enum GoodStatusEnum implements CodeEnum{

    /**
     * 商品状态为在架
     */
    UP(0,"在架"),

    /**
     * 商品状态为下架
     */
    DOWN(1,"下架");

    private Integer code;

    private String msg;

    GoodStatusEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
