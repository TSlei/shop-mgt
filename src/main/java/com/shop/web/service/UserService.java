package com.shop.web.service;

import com.shop.web.entity.User;

public interface UserService {
	
	User login(String name ,String passWord);
}
