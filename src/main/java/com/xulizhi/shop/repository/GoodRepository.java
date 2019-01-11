package com.xulizhi.shop.repository;

import com.xulizhi.shop.domain.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author lenovo
 */
public interface GoodRepository extends JpaRepository<Good,String>{

    List<Good> findByStatus(Integer status);

    List<Good> findByCategoryId(String categoryId);

    List<Good> findByCategoryIdAndStatus(String categoryId,Integer status);
}
