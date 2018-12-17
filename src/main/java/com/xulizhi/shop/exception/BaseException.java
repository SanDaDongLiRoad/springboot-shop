package com.xulizhi.shop.exception;

import com.xulizhi.shop.enums.ResultEnum;
import lombok.Getter;

/**
 * @author lenovo
 */
@Getter
public class BaseException extends RuntimeException{

    /**
     * 异常码
     */
    private Integer code;

    public BaseException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
