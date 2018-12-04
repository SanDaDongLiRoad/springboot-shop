package com.xulizhi.shop.service.impl;

import com.xulizhi.shop.domain.Category;
import com.xulizhi.shop.domain.Good;
import com.xulizhi.shop.repository.GoodRepository;
import com.xulizhi.shop.service.CategoryService;
import com.xulizhi.shop.service.GoodService;
import com.xulizhi.shop.vo.BuyerGoodListVO;
import com.xulizhi.shop.vo.BuyerGoodVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo
 */
@Service
public class GoodServiceImpl implements GoodService{

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<BuyerGoodListVO> listBuyerGood() {

        List<BuyerGoodListVO> buyerGoodListVOList = new ArrayList<BuyerGoodListVO>();
        List<Category> categoryList = categoryService.listCategory();

        for(int i=0;i<categoryList.size();i++){
            BuyerGoodListVO buyerGoodListVO = new BuyerGoodListVO();
            List<BuyerGoodVO>  buyerGoods = new ArrayList<BuyerGoodVO>();
            Category category = categoryList.get(i);
            buyerGoodListVO.setId(category.getId());
            buyerGoodListVO.setName(category.getName());
            List<Good> goods = goodRepository.findByCategoryId(category.getId());
            for(int j=0;j<goods.size();j++){
                BuyerGoodVO buyerGoodVO = new BuyerGoodVO();
                BeanUtils.copyProperties(goods.get(j),buyerGoodVO);
                buyerGoods.add(buyerGoodVO);
            }
            buyerGoodListVO.setBuyerGoods(buyerGoods);
            buyerGoodListVOList.add(buyerGoodListVO);
        }
        return buyerGoodListVOList;
    }
}
