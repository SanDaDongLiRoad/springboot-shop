package com.xulizhi.shop.service;

import com.xulizhi.shop.domain.Order;
import com.xulizhi.shop.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author lenovo
 */
public interface OrderService {

    /**
     * 分页查询订单列表
     * @param pageable
     * @return
     */
    Page<OrderDTO> listOrderByPage(Pageable pageable);

    /**
     * 取消订单
     * @param id
     * @return
     */
    Order cancel(String id);
}
