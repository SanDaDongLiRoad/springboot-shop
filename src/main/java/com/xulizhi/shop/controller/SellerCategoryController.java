package com.xulizhi.shop.controller;

import com.xulizhi.shop.domain.Category;
import com.xulizhi.shop.form.CategoryForm;
import com.xulizhi.shop.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("sellerCategory")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 类目首页
     * @param id
     * @param map
     * @return
     */
    @GetMapping("indexCatagory")
    public ModelAndView indexCatagory(@RequestParam(required = false) String id, Map<String, Object> map){
        if (!Objects.equals(null,id)) {
            Category category = categoryService.getCategoryById(id);
            map.put("category", category);
        }

        return new ModelAndView("category/index", map);
    }

    /**
     * 获取类目列表
     * @param map
     * @return
     */
    @GetMapping("listCategory")
    public ModelAndView listCategory(Map<String, Object> map){

        List<Category> categoryList = categoryService.listCategoryOrderByUpdate();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    /**
     * 保存获更新类目
     * @param categoryForm
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("saveCategory")
    public ModelAndView saveCategory(@Valid CategoryForm categoryForm, BindingResult bindingResult, Map<String, Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/shop/sellerCategory/indexCatagory");
            return new ModelAndView("common/error", map);
        }
        try{
            categoryService.saveCategory(categoryForm);
        }catch(Exception e){
            e.printStackTrace();
            map.put("msg", e.getMessage());
            map.put("url", "/shop/sellerCategory/indexCatagory");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/shop/sellerCategory/listCategory");
        return new ModelAndView("common/success", map);
    }
}
