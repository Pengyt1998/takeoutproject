package com.aciel.reggie.service.impl;

import com.aciel.reggie.entity.OrderDetail;
import com.aciel.reggie.mapper.OrderDetailMapper;
import com.aciel.reggie.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单明细表 服务实现类
 * </p>
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
