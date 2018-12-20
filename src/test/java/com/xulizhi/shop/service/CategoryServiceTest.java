package com.xulizhi.shop.service;

import com.xulizhi.shop.domain.Category;
import com.xulizhi.shop.form.CategoryForm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void listCategory() {
        List<Category> categoryList = categoryService.listCategoryOrderByUpdate();
        log.info("categoryList{}",categoryList);
    }

    @Test
    public void saveCategory() {
        CategoryForm categoryForm = new CategoryForm();
        categoryForm.setId("1543844553710170091");
        categoryForm.setName("测试类目09");
        Category category = categoryService.saveCategory(categoryForm);
        log.info("category{}",category);
    }
}