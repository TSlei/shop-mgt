package com.shop.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.web.entity.Order;
public interface OrderMapper {

    int insertOrder(Order record);

    List<Order> listOrder(@Param("status")Integer status);
    
    Integer deleteOrder(@Param("orderId")Integer orderId);
    
    Order getOrderById(@Param("orderId")Integer orderId);
    
    Integer updateOrder(Order order);
    
    Integer selectOrderDetailCount(@Param("sid")Integer sid);
    
    List<Order> selectMonthTheSales(@Param("list")List<String> monthDate);
}