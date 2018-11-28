package com.xulizhi.shop.domain;

import com.xulizhi.shop.common.BaseDomain;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author lenovo
 */
@Data
@Entity
public class Seller extends BaseDomain{

    private static final long serialVersionUID = 5229882526270417015L;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * openid
     */
    private String openid;
}
