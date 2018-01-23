package com.shop.web.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.shop.web.entity.Order;

public interface OrderService {
	List<Order> listOrder(Integer status);
	
	Integer insertOrder(Order order);
	
	
    /**
     * 说明：
     * @param @param orderId
     * @param @return 0存在商品 不能删除  1删除成功
     * @author XuL  2017年1月24日
     */
    Integer deleteOrder(Integer orderId);
    
    Order getOrderById(Integer orderId);
    
    Integer updateOrder(Order order);
    
    JSONObject selectMonthTheSales(Integer yearNum);
}
