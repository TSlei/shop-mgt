package com.shop.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.web.entity.Item;
import com.shop.web.entity.OrderDetail;
import com.shop.web.mapper.ItemMapper;
import com.shop.web.mapper.OrderDetailMapper;
import com.shop.web.service.OrderDetailService;
@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	private OrderDetailMapper orderDetailMapper;
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public List<OrderDetail> listOrderDetail(Integer orderId) {
		return orderDetailMapper.listOrderDetail(orderId);
	}
	@Override
	public Integer insertOrderDetail(OrderDetail orderDetail) {
		Item item = itemMapper.getItemByCode(orderDetail.getItemCode());
		if(item == null){
			return 0;
		}else{
			Long createTime = System.currentTimeMillis();
			orderDetail.setItemId(item.getId());
			orderDetail.setItemName(item.getName());;
			orderDetail.setCreateTime(createTime);
			orderDetail.setUpdateTime(createTime);
			
			Integer i = orderDetailMapper.insertOrderDetail(orderDetail);
			
			Integer num = (int) (item.getNum() - orderDetail.getNumber());
			if(num < 0){
				i = 5;
			}
			item.setNum(num);
			item.setUpdateTime(createTime);
			itemMapper.updateNum(item);
			return i;
		}
		
	}
	@Override
	public Integer deleteOrderDetail(Integer orderDetailId) {
		
		OrderDetail orderDetail = orderDetailMapper.getOrderDetailById(orderDetailId);
		
		Item item = itemMapper.getItemById(orderDetail.getItemId());
		
		Integer num = (int) (item.getNum() + orderDetail.getNumber());
		item.setNum(num);
		
		Integer i = orderDetailMapper.deleteOrderDetail(orderDetailId);
		
		itemMapper.updateNum(item);
		
		return i;
	}

}
