package com.aciel.reggie.controller;


import com.aciel.reggie.common.R;
import com.aciel.reggie.dto.OrdersDto;
import com.aciel.reggie.entity.Orders;
import com.aciel.reggie.service.OrdersService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/order")
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    /**
     * 添加订单
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public R addOrders(@RequestBody Orders orders){
        ordersService.addOrders(orders);
        return R.success("下单成功！");
    }

    /**
     * 获取订单详情
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/userPage")
    public R getOrders(Integer page, Integer pageSize){
        Page<OrdersDto> ordersDtoPage = ordersService.userPage(page,pageSize);
        return R.success(ordersDtoPage);
    }

}

