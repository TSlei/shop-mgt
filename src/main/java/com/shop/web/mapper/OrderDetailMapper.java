package com.shop.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.web.entity.OrderDetail;

public interface OrderDetailMapper {
	List<OrderDetail> listOrderDetail(@Param("orderId")Integer orderId);
	
	Integer getCountByItemId(@Param("itemId") Integer itemId);
	
	Integer insertOrderDetail(OrderDetail orderDetail);
	
	Integer deleteOrderDetail(@Param("id")Integer orderDetailId);
	
	OrderDetail getOrderDetailById(@Param("id")Integer orderDetailId);
}
