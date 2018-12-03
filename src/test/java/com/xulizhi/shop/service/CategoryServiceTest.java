package com.xulizhi.shop.service;

import com.xulizhi.shop.domain.Category;
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
        List<Category> categoryList = categoryService.listCategory();
        log.info("categoryList{}",categoryList);
    }

    @Test
    public void saveCategory() {
        Category category = new Category();
        category.setId("1543824739697880859");
        category.setName("测试类目01");
        category = categoryService.saveCategory(category);
        log.info("category{}",category);
    }
}