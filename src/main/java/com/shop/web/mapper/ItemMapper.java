package com.shop.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.web.entity.Item;


public interface ItemMapper {

	Integer deleteByPrimaryKey(Long id);

    Integer insertItem(Item item);
    
    Item getItemById(@Param("id")Long id);
    
    Integer getCountByCode(@Param("code")String code);
    
    Integer getItemIdByCode(@Param("code")String code);
    
    Item getItemByCode(@Param("code")String code);

    Integer updateItem(Item item);
    
    List<Item> listItem(Item item);
    
    Integer updateNum(Item item);
}