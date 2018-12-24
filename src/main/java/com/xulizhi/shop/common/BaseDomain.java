package com.xulizhi.shop.common;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lenovo
 */
@Data
@MappedSuperclass
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = 8883053754292831158L;
    /**
     * 主键ID
     */
    @Id
    private String id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     *  更新时间
     */
    private Date updateTime;
}
