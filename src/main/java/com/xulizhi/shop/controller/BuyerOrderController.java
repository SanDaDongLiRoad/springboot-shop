package com.xulizhi.shop.controller;

import com.xulizhi.shop.form.OrderForm;
import com.xulizhi.shop.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * 卖家端订单Controller
 * @author lenovo
 */
@Slf4j
@RestController
@RequestMapping("buyerOrder")
public class BuyerOrderController {

    /**
     * 创建订单8
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("createOrder")
    public ResultVO<Map<String,String>> createOrder(@RequestBody @Valid OrderForm orderForm, BindingResult bindingResult){
        return null;
    }


}
