package com.xulizhi.shop.service.impl;

import com.xulizhi.shop.domain.Category;
import com.xulizhi.shop.form.CategoryForm;
import com.xulizhi.shop.repository.CategoryRepository;
import com.xulizhi.shop.service.CategoryService;
import com.xulizhi.shop.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author lenovo
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(String id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public List<Category> listCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        Category saveCategory = new Category();
        if(!Objects.equals(null,category.getId())){
            saveCategory = getCategoryById(category.getId());
        }else{
            category.setId(KeyUtil.genUniqueKey());
        }
        BeanUtils.copyProperties(category,saveCategory);
        return categoryRepository.save(saveCategory);
    }
}
