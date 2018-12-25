package com.xulizhi.shop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xulizhi.shop.enums.OrderStatusEnum;
import com.xulizhi.shop.enums.PayStatusEnum;
import com.xulizhi.shop.utils.EnumUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lenovo
 */
@Data
public class OrderDTO {

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 客户手机号
     */
    private String customerPhone;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 订单总额
     */
    private BigDecimal amount;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getEnumByCode(status,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getEnumByCode(payStatus,PayStatusEnum.class);
    }

    /**
     * 订单详情列表
     */
    private List<OrderDetailDTO> orderDetailDTOList;

}
