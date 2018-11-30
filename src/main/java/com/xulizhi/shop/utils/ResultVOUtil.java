package com.xulizhi.shop.utils;

import com.xulizhi.shop.enums.ResultEnum;
import com.xulizhi.shop.vo.ResultVO;

/**
 * @author lenovo
 */
public class ResultVOUtil {

    public static ResultVO success(Object data){

        ResultVO resultVO = new ResultVO(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),data);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO(code,msg,null);
        return resultVO;
    }
}
