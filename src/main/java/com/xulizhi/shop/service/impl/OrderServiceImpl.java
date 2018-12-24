package com.xulizhi.shop.service.impl;

import com.xulizhi.shop.domain.Customer;
import com.xulizhi.shop.domain.Order;
import com.xulizhi.shop.dto.OrderDTO;
import com.xulizhi.shop.repository.OrderRepository;
import com.xulizhi.shop.service.CustomerService;
import com.xulizhi.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    @Override
    public Page<OrderDTO> listOrderByPage(Pageable pageable) {

        Page<Order> orderPage = orderRepository.findAll(pageable);

        List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();

        for(int i=0;i<orderPage.getContent().size();i++){
            OrderDTO orderDTO = new OrderDTO();
            Order order = orderPage.getContent().get(i);
            Customer customer = customerService.getCustomerById(order.getCustomerId());
            orderDTO.setOrderId(order.getId());
            orderDTO.setCustomerName(customer.getName());
            orderDTO.setCustomerPhone(customer.getPhone());
            orderDTO.setAddress(customer.getAddress());
            orderDTO.setAmount(order.getAmount());
            orderDTO.setStatus(order.getStatus());
            orderDTO.setPayStatus(order.getPayStatus());
            orderDTO.setCreateTime(order.getCreateTime());
            orderDTOList.add(orderDTO);
        }
        return new PageImpl<>(orderDTOList, pageable, orderPage.getTotalElements());
    }
}
