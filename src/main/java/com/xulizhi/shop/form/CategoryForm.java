package com.xulizhi.shop.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author lenovo
 */
@Data
public class CategoryForm {

    /**
     * 类目ID
     */
    private String id;

    /**
     * 类目名称
     */
    @NotEmpty(message = "类目名称必填")
    private String name;

}
