package com.shop.web.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shop.tools.VelocityTool;
import com.shop.web.entity.Order;
import com.shop.web.mapper.OrderMapper;
import com.shop.web.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper mapper;

	@Override
	public List<Order> listOrder(Integer status) {
		return mapper.listOrder(status);
	}

	@Override
	public Integer insertOrder(Order order) {
		return mapper.insertOrder(order);
	}

	@Override
	public Integer deleteOrder(Integer orderId) {
		Integer i = mapper.selectOrderDetailCount(orderId);
		if(i == 0){
			return mapper.deleteOrder(orderId);	
		}else{
			return 0;
		}
	}

	@Override
	public Order getOrderById(Integer orderId) {
		return mapper.getOrderById(orderId);
	}

	@Override
	public Integer updateOrder(Order order) {
		return mapper.updateOrder(order);
	}

	@Override
	public JSONObject selectMonthTheSales() {
		String[] monthDate = VelocityTool.getLast12Months();
		Arrays.sort(monthDate);
		List<Order> list = mapper.selectMonthTheSales(Arrays.asList(monthDate));
		JSONObject obj = new JSONObject();
		JSONArray arrayX = new JSONArray();
		JSONArray arrayY = new JSONArray();
		JSONArray arrayZ = new JSONArray();
		Integer totalPrice = 0;
		Integer totalNum = 0;
		for (String string : monthDate) {
			arrayX.add(string);
			boolean flag = true;
			for (Order order : list) {
				if(string.equals(order.getMonthDate())){
					arrayY.add(order.getCountPrice());
					arrayZ.add(order.getCountNum());
					totalPrice += Integer.parseInt(order.getCountPrice());
					totalNum += order.getCountNum();
					flag = false;
				}
			}
			if(flag){
				arrayY.add(0);
				arrayZ.add(0);
			}
		}
		arrayX.add("总计");
		arrayY.add(totalPrice);
		arrayZ.add(totalNum);
		obj.put("arrayX", arrayX);
		obj.put("arrayY", arrayY);
		obj.put("arrayZ", arrayZ);
		return obj;
	}
}
