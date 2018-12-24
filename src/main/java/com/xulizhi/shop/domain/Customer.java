package com.xulizhi.shop.domain;

import com.xulizhi.shop.common.BaseDomain;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author lenovo
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_customer")
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
