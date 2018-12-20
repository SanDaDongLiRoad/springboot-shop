package com.xulizhi.shop.service;

import com.xulizhi.shop.domain.Category;
import com.xulizhi.shop.form.CategoryForm;

import java.util.List;

/**
 * @author lenovo
 */
public interface CategoryService {

    /**
     * 根据类目ID获取单个类目
     * @param id
     * @return
     */
    Category getCategoryById(String id);

    /**
     * 获取类目列表
     * @return
     */
    List<Category> listCategoryOrderByUpdate();

    /**
     * 保存或更新类目
     * @param categoryForm
     * @return
     */
    Category saveCategory(CategoryForm categoryForm);
}
