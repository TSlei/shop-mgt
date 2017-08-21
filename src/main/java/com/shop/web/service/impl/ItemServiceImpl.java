package com.shop.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.web.entity.Item;
import com.shop.web.mapper.ItemMapper;
import com.shop.web.mapper.OrderDetailMapper;
import com.shop.web.mapper.OrderMapper;
import com.shop.web.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

@Autowired
private ItemMapper itemMapper;

@Autowired
private OrderMapper orderMapper;
@Autowired
private OrderDetailMapper detailMapper;
	
   
	public Integer addItem(Item item) {
		Integer i = itemMapper.getCountByCode(item.getCode());
		if(i!=0){
			return 0;
		}else{
			itemMapper.insertItem(item);
			return 1;
		}
		
	}


	@Override
	public List<Item> listItem(Item item) {
		return itemMapper.listItem(item);
	}

	


	@Override
	public Integer deleteItem(Integer itemId) {
		Integer i = detailMapper.getCountByItemId(itemId);
		if(i == 0){
			itemMapper.deleteByPrimaryKey(Long.parseLong(itemId+""));
			return 1;
		}else{
			return 0;
		}
	}


	@Override
	public Item getItem(Integer itemId) {
		return itemMapper.getItemById(Long.parseLong(itemId+""));
	}


	@Override
	public Integer updateItem(Item item) {
		Integer i = itemMapper.getItemIdByCode(item.getCode());
		if(! (i+"").equals(item.getId()+"")){
			return 0;
		}else{
			itemMapper.updateItem(item);
			return 1;
		}
	}


	@Override
	public List<Item> queryLikeItem(String makerName) {
		Item item = new Item();
		item.setMakerName(makerName);
		return itemMapper.listItem(item);
	}

}
