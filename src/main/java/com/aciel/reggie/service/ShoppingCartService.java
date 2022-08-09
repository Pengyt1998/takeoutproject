package com.aciel.reggie.service;

import com.aciel.reggie.entity.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 购物车 服务类
 * </p>
 */
public interface ShoppingCartService extends IService<ShoppingCart> {

    void add(ShoppingCart shoppingCart);

    List<ShoppingCart> getList();

    void sub(ShoppingCart shoppingCart);
}
