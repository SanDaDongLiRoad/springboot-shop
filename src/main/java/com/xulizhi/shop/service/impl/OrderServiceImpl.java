package com.xulizhi.shop.service.impl;

import com.xulizhi.shop.domain.Customer;
import com.xulizhi.shop.domain.Order;
import com.xulizhi.shop.domain.OrderGoodRelation;
import com.xulizhi.shop.dto.OrderDTO;
import com.xulizhi.shop.enums.OrderStatusEnum;
import com.xulizhi.shop.enums.ResultEnum;
import com.xulizhi.shop.exception.BaseException;
import com.xulizhi.shop.repository.OrderRepository;
import com.xulizhi.shop.service.CustomerService;
import com.xulizhi.shop.service.GoodService;
import com.xulizhi.shop.service.OrderGoodRelationService;
import com.xulizhi.shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author lenovo
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderGoodRelationService orderGoodRelationService;

    @Autowired
    private GoodService goodService;

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

    @Override
    @Transactional
    public Order cancel(String id) {

        Order order = orderRepository.findOne(id);
        if(!Objects.equals(OrderStatusEnum.NEW.getCode(),order.getStatus())){
            throw new BaseException(ResultEnum.ORDER_STATUS_ERROR);
        }
        order.setStatus(OrderStatusEnum.CANCEL.getCode());
        orderRepository.save(order);

        List<OrderGoodRelation> orderGoodRelationList = orderGoodRelationService.queryOrderGoodRelationByOrderId(id);

        //退库存
        for(int i=0;i<orderGoodRelationList.size();i++){
            OrderGoodRelation orderGoodRelation = orderGoodRelationList.get(i);
            goodService.increaseStock(orderGoodRelation.getGoodId(),orderGoodRelation.getQuantity());
        }

        //如果已支付, 需要退款

        return order;
    }
}
