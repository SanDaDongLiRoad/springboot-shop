package com.xulizhi.shop.vo;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * @author lenovo
 */
@Data
public class ResultVO<T> {

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
