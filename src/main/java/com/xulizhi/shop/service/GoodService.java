package com.xulizhi.shop.service;

import com.xulizhi.shop.vo.BuyerGoodListVO;

import java.util.List;

/**
 * @author lenovo
 */
public interface GoodService {

    /**
     * 获取买家端商品列表（按照类目分类）
     * @return
     */
    List<BuyerGoodListVO> listBuyerGood();
}
