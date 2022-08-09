package com.aciel.reggie.dto;


import com.aciel.reggie.entity.OrderDetail;
import com.aciel.reggie.entity.Orders;
import lombok.Data;

import java.util.List;

@Data
public class OrdersDto extends Orders {

    private List<OrderDetail> orderDetails;
	
}
