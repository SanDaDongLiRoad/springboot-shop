package com.xulizhi.shop.utils;

import com.xulizhi.shop.enums.CodeEnum;

import java.util.Objects;

/**
 * @author lenovo
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass){
        for(T each : enumClass.getEnumConstants()){
            if(Objects.equals(code,each.getCode())){
                return each;
            }
        }
        return null;
    }
}
