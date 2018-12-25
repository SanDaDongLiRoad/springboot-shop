package com.xulizhi.shop.controller;

import com.xulizhi.shop.dto.OrderDTO;
import com.xulizhi.shop.enums.ResultEnum;
import com.xulizhi.shop.exception.BaseException;
import com.xulizhi.shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author lenovo
 */
@Slf4j
@Controller
@RequestMapping("sellerOrder")
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 分页查询订单列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("listOrder")
    public ModelAndView listOrder(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size, Map<String, Object> map){
        PageRequest request = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.listOrderByPage(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }

    /**
     * 取消订单
     * @param id
     * @return
     */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("id") String id,Map<String, Object> map) {
        try {
            orderService.cancel(id);
        } catch (BaseException e) {
            log.error("【卖家端取消订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/shop/sellerOrder/listOrder");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMsg());
        map.put("url", "/shop/sellerOrder/listOrder");
        return new ModelAndView("common/success");
    }

    /**
     * 订单详情
     * @param id
     * @param map
     * @return
     */
    @GetMapping("sellerOrderDetail")
    public ModelAndView sellerOrderDetail(@RequestParam("id") String id,Map<String, Object> map){
        OrderDTO orderDTO = new OrderDTO();
        try{
            orderDTO = orderService.getSellerOrderDetail(id);
        }catch(BaseException e){
            log.error("【卖家端查询订单详情】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/shop/sellerOrder/listOrder");
            return new ModelAndView("common/error", map);
        }
        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);
    }

    @GetMapping("finishOrder")
    public ModelAndView sellerOrderFinish(@RequestParam("id") String id,Map<String, Object> map){
        try {
            orderService.finishOrder(id);
        } catch (BaseException e) {
            log.error("【卖家端完结订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/shop/sellerOrder/listOrder");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMsg());
        map.put("url", "/shop/sellerOrder/listOrder");
        return new ModelAndView("common/success");
    }
}
