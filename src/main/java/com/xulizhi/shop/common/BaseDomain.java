package com.xulizhi.shop.common;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd hh24:mm:ss a", locale="zh", timezone="GMT+8")
    private Date createTime;

    /**
     *  更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh24:mm:ss a", locale="zh", timezone="GMT+8")
    private Date updateTime;
}
