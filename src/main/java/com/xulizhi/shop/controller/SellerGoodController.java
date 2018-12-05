package com.xulizhi.shop.controller;


import com.xulizhi.shop.domain.Category;
import com.xulizhi.shop.domain.Good;
import com.xulizhi.shop.exception.BaseException;
import com.xulizhi.shop.service.CategoryService;
import com.xulizhi.shop.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 卖家端商品Controller
 * @author lenovo
 */
@Slf4j
@Controller
@RequestMapping("sellerGood")
public class SellerGoodController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 卖家端商品首页
     * @param id
     * @param map
     * @return
     */
    @GetMapping("indexSellerGood")
    public ModelAndView indexSellerGood(@RequestParam(value = "id", required = false) String id, Map<String, Object> map){

        if(!Objects.equals(null,id)){
            Good good = goodService.findGoodById(id);
            map.put("good",good);
        }
        List<Category> categoryList = categoryService.listCategory();
        map.put("categoryList",categoryList);
        return new ModelAndView("product/index", map);
    }

    /**
     * 分页查询商品列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("listGoodByPage")
    public ModelAndView listGoodByPage(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size, Map<String, Object> map){
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<Good> goodList = goodService.listGoodByPage(pageRequest);
        map.put("goodList", goodList);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }

    /**
     * 上架商品
     * @param id
     * @param map
     * @return
     */
    @GetMapping("onSale")
    public ModelAndView onSale(@RequestParam("id") String id, Map<String, Object> map){
        try {
            goodService.onSale(id);
        } catch (BaseException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * 下架商品
     * @param id
     * @param map
     * @return
     */
    @GetMapping("offSale")
    public ModelAndView offSale(@RequestParam("id") String id, Map<String, Object> map){
        try {
            goodService.offSale(id);
        } catch (BaseException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
