package com.aciel.reggie.controller;


import com.aciel.reggie.common.R;
import com.aciel.reggie.entity.ShoppingCart;
import com.aciel.reggie.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 购物车 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Resource
    private ShoppingCartService shoppingCartService;

    /**
     * 查询购物车所有商品
     * @return
     */
    @GetMapping("/list")
    public R getList(){
        List<ShoppingCart> list = shoppingCartService.getList();
        return R.success(list);
    }

    /**
     * 添加购物车项
     * @param shoppingCart
     * @return
     */
    @PostMapping("/add")
    public R add(@RequestBody ShoppingCart shoppingCart){

        shoppingCartService.add(shoppingCart);
        return R.success("添加成功！");
    }
    @PostMapping("/sub")
    public R sub(@RequestBody ShoppingCart shoppingCart){
        shoppingCartService.sub(shoppingCart);
        return R.success("取消成功");
    }
}

