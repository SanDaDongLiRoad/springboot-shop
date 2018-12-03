package com.xulizhi.shop.domain;

import com.xulizhi.shop.common.BaseDomain;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;

/**
 * @author lenovo
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class Category extends BaseDomain{

    private static final long serialVersionUID = 7182985014591602174L;
    /**
     * 类目名字
     */
    private String name;
}
