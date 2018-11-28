package com.xulizhi.shop.domain;

import com.xulizhi.shop.common.BaseDomain;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author lenovo
 */
@Data
@Entity
public class Customer extends BaseDomain {


    private static final long serialVersionUID = -2759037679856189913L;

    /**
     * 买家名字
     */
    private String name;

    /**
     * 买家手机号
     */
    private String phone;

    /**
     * 买家地址
     */
    private String address;

    /**
     * 买家微信openid
     */
    private String openid;
}
