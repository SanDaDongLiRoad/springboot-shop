package com.xulizhi.shop.service;

import com.xulizhi.shop.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author lenovo
 */
public interface OrderService {

    Page<OrderDTO> listOrderByPage(Pageable pageable);
}
