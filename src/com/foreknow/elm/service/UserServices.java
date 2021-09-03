package com.foreknow.elm.service;

import com.foreknow.elm.po.User;

public interface UserServices {
	User getUserByIdByPass(String userId, String password);
	
	int getUserById(String userId);
	
	int saveUser(String userId, String password, String userName, Integer userSex);
}
