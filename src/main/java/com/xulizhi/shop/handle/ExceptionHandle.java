package com.xulizhi.shop.handle;

import com.xulizhi.shop.enums.ResultEnum;
import com.xulizhi.shop.exception.BaseException;
import com.xulizhi.shop.utils.ResultVOUtil;
import com.xulizhi.shop.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lenovo
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultVO handle(Exception e){
        if(e instanceof BaseException){
            BaseException baseException = (BaseException) e;
            return ResultVOUtil.error(baseException.getCode(), baseException.getMessage());
        }else{
            log.error("【系统异常】{}", e);
            return ResultVOUtil.error(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMsg());
        }
    }
}
