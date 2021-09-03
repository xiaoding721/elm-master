package com.foreknow.elm.dao;

import com.foreknow.elm.po.User;

public interface UserDao {
	User getUserByIdByPass(String userId, String password);
	
	int getUserById(String userId);
	
	int saveUser(String userId, String password, String userName, Integer userSex);
}
