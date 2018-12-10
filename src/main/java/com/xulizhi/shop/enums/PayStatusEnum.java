package com.xulizhi.shop.enums;

import lombok.Getter;

/**
 * @author 10133
 */
@Getter
public enum PayStatusEnum {

    UNPAID(0,"未支付"),
    PAID(1,"已支付");

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
