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
    public Category saveCategory(CategoryForm categoryForm) {
        Category saveCategory = new Category();
        if(!Objects.equals(null,categoryForm.getId())){
            saveCategory = getCategoryById(categoryForm.getId());
            BeanUtils.copyProperties(categoryForm,saveCategory);
        }else{
            BeanUtils.copyProperties(categoryForm,saveCategory);
            saveCategory.setId(KeyUtil.genUniqueKey());

        }
        return categoryRepository.save(saveCategory);
    }
}
