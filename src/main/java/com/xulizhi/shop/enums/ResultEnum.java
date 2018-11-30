package com.xulizhi.shop.enums;

import lombok.Getter;

/**
 * @author lenovo
 */

@Getter
public enum ResultEnum {

    /**
     * 请求成功
     */
    SUCCESS(0, "成功"),
    /**
     * 参数不正确
     */
    PARAM_ERROR(1, "参数不正确"),
    /**
     * 系统异常
     */
    ERROR(-1,"未知错误");

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
