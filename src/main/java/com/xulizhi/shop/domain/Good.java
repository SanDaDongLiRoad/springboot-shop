package com.xulizhi.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xulizhi.shop.common.BaseDomain;
import com.xulizhi.shop.enums.GoodStatusEnum;
import com.xulizhi.shop.utils.EnumUtil;
import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author lenovo
 */
@Data
@Entity
public class Good extends BaseDomain{

    private static final long serialVersionUID = 6553377955521129177L;
    /**
     * 商品名字
     */
    private String name;

    /**
     * 商品单价
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 描述
     */
    private String description;

    /**
     * 商品图片
     */
    private String icon;

    /**
     * 商品状态
     */
    private Integer status;

    /**
     * 类目ID
     */
    private String categoryId;

    @JsonIgnore
    public GoodStatusEnum getGoodStatusEnum(){
        return EnumUtil.getEnumByCode(status,GoodStatusEnum.class);
    }

}
