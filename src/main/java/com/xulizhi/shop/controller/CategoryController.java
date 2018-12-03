package com.xulizhi.shop.controller;

import com.xulizhi.shop.domain.Category;
import com.xulizhi.shop.form.CategoryForm;
import com.xulizhi.shop.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 类目Controller
 * @author lenovo
 */
@Slf4j
@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取类目列表
     * @param map
     * @return
     */
    @GetMapping("listCategory")
    public ModelAndView listCategory(Map<String, Object> map){

        List<Category> categoryList = categoryService.listCategory();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    /**
     * 保存获更新类目
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("saveCategory")
    public ModelAndView saveCategory(@Valid CategoryForm form, BindingResult bindingResult, Map<String, Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/shop/category/index");
            return new ModelAndView("common/error", map);
        }
        Category category = new Category();
        BeanUtils.copyProperties(form,category);
        try{
            categoryService.saveCategory(category);
        }catch(Exception e){
            map.put("msg", e.getMessage());
            map.put("url", "/shop/category/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/shop/category/list");
        return new ModelAndView("common/success", map);
    }
}
