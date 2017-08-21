package com.shop.web.service;

import java.util.List;

import com.shop.web.entity.Item;

public interface ItemService {

	/**
	 * 说明：添加 
	 * @param @param item
	 * @param @return 0编号已存在   1添加成功
	 * @author XuL  2017年1月23日
	 */
	Integer addItem(Item item);
	
	
	List<Item> listItem(Item item);
	
	/**
	 * 说明：
	 * @param @param itemId
	 * @param @return 0存在关联不能删除  1删除成功
	 * @author XuL  2017年1月23日
	 */
	Integer deleteItem(Integer itemId);
	
	
	Item getItem(Integer itemId);
	
	/**
	 * 说明：
	 * @param @param item
	 * @param @return 0 编号已存在 1更新成功
	 * @author XuL  2017年1月23日
	 */
	Integer updateItem(Item item);
	
	List<Item> queryLikeItem(String makerName);
}
