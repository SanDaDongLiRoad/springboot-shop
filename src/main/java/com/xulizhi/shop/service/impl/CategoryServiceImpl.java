package com.xulizhi.shop.service.impl;

import com.xulizhi.shop.domain.Category;
import com.xulizhi.shop.form.CategoryForm;
import com.xulizhi.shop.repository.CategoryRepository;
import com.xulizhi.shop.service.CategoryService;
import com.xulizhi.shop.utils.KeyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public List<Category> listCategoryOrderByCreate() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        return categoryRepository.findAll(sort);
    }

    @Override
    public Category saveCategory(CategoryForm categoryForm) {
        Category saveCategory = new Category();
        if(StringUtils.isNotEmpty(categoryForm.getId())){
            saveCategory = getCategoryById(categoryForm.getId());
            BeanUtils.copyProperties(categoryForm,saveCategory);
        }else{
            BeanUtils.copyProperties(categoryForm,saveCategory);
            saveCategory.setId(KeyUtil.genUniqueKey());

        }
        return categoryRepository.save(saveCategory);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }
}
