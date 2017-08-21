package com.shop.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.web.entity.User;
import com.shop.web.mapper.UserMapper;
import com.shop.web.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired 
	private UserMapper userMapper;
	@Override
	public User login(String name, String passWord) {
		return userMapper.login(name, passWord);
	}
	
}
