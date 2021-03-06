package com.xulizhi.shop.service.impl;

import com.xulizhi.shop.domain.Category;
import com.xulizhi.shop.domain.Good;
import com.xulizhi.shop.enums.GoodStatusEnum;
import com.xulizhi.shop.enums.ResultEnum;
import com.xulizhi.shop.exception.BaseException;
import com.xulizhi.shop.form.GoodForm;
import com.xulizhi.shop.repository.GoodRepository;
import com.xulizhi.shop.service.CategoryService;
import com.xulizhi.shop.service.GoodService;
import com.xulizhi.shop.utils.KeyUtil;
import com.xulizhi.shop.vo.BuyerGoodListVO;
import com.xulizhi.shop.vo.BuyerGoodVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        List<Category> categoryList = categoryService.listCategoryOrderByCreate();

        for(int i=0;i<categoryList.size();i++){
            BuyerGoodListVO buyerGoodListVO = new BuyerGoodListVO();
            List<BuyerGoodVO>  buyerGoods = new ArrayList<BuyerGoodVO>();
            Category category = categoryList.get(i);
            buyerGoodListVO.setId(category.getId());
            buyerGoodListVO.setName(category.getName());
            List<Good> goods = listUpGoodByCategroy(category.getId());
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

    @Override
    public Good findGoodById(String id) {
        return goodRepository.findOne(id);
    }

    @Override
    public Page<Good> listGoodByPage(Pageable pageable) {
        return goodRepository.findAll(pageable);
    }

    @Override
    public Good onSale(String id) {
        Good good  = goodRepository.findOne(id);
        if(Objects.equals(null,good)){
            throw new BaseException(ResultEnum.GOOD_NOT_EXIST);
        }else if(Objects.equals(good.getStatus(), GoodStatusEnum.UP)){
            throw new BaseException(ResultEnum.GOOD_STATUS_ERROR);
        }
        good.setStatus(GoodStatusEnum.UP.getCode());
        return goodRepository.save(good);
    }

    @Override
    public Good offSale(String id) {
        Good good  = goodRepository.findOne(id);
        if(Objects.equals(null,good)){
            throw new BaseException(ResultEnum.GOOD_NOT_EXIST);
        }else if(Objects.equals(good.getStatus(), GoodStatusEnum.DOWN)){
            throw new BaseException(ResultEnum.GOOD_STATUS_ERROR);
        }
        good.setStatus(GoodStatusEnum.DOWN.getCode());
        return goodRepository.save(good);
    }

    @Override
    public Good saveGood(GoodForm goodform) {
        Good saveGood = new Good();
        if(StringUtils.isNotEmpty(goodform.getId())){
            saveGood = goodRepository.findOne(goodform.getId());
            BeanUtils.copyProperties(goodform,saveGood);
        }else{
            BeanUtils.copyProperties(goodform,saveGood);
            saveGood.setId(KeyUtil.genUniqueKey());
        }
        goodRepository.save(saveGood);
        return saveGood;
    }

    @Override
    @Transactional
    public void increaseStock(String id, Integer stock) {
        Good good = goodRepository.findOne(id);
        if(Objects.equals(null,good)){
            throw new BaseException(ResultEnum.GOOD_NOT_EXIST);
        }
        Integer resultStock = good.getStock() + stock;
        good.setStock(resultStock);
        goodRepository.save(good);
    }

    @Override
    @Transactional
    public void decreaseStock(String id, Integer stock) {
        Good good = goodRepository.findOne(id);
        if(Objects.equals(null,good)){
            throw new BaseException(ResultEnum.GOOD_NOT_EXIST);
        }
        Integer resultStock = good.getStock() - stock;
        good.setStock(resultStock);
        goodRepository.save(good);
    }

    @Override
    public List<Good> listUpGoodByCategroy(String categroyId) {
        return goodRepository.findByCategoryIdAndStatus(categroyId, GoodStatusEnum.UP.getCode());
    }
}
