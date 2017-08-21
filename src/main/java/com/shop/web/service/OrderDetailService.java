package com.shop.web.service;

import java.util.List;

import com.shop.web.entity.OrderDetail;

public interface OrderDetailService {
	List<OrderDetail> listOrderDetail(Integer orderId);
	
	Integer insertOrderDetail(OrderDetail orderDetail);
	
	Integer deleteOrderDetail(Integer orderDetailId);
	
}
