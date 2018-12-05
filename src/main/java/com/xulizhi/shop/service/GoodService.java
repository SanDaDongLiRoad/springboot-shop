package com.xulizhi.shop.service;

import com.xulizhi.shop.domain.Good;
import com.xulizhi.shop.vo.BuyerGoodListVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    /**
     * 根据商品Id获取商品
     * @param id
     * @return
     */
    Good findGoodById(String id);

    /**
     * 分页查询商品列表
     * @param pageable
     * @return
     */
    Page<Good> listGoodByPage(Pageable pageable);

    /**
     * 上架商品
     * @param id
     * @return
     */
    Good onSale(String id);

    /**
     * 下架商品
     * @param id
     * @return
     */
    Good offSale(String id);

}
