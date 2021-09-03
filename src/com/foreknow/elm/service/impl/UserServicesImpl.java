package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.UserDao;
import com.foreknow.elm.dao.impl.UserDaoImpl;
import com.foreknow.elm.po.User;
import com.foreknow.elm.service.UserServices;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;

public class UserServicesImpl implements UserServices {
	@Override
	public User getUserByIdByPass(String userId, String password) {
		UserDao dao = new UserDaoImpl();
		return dao.getUserByIdByPass(userId,password);
	}
	
	@Override
	public int getUserById(String userId) {
		UserDao dao = new UserDaoImpl();
		return dao.getUserById(userId);
	}
	
	@Override
	public int saveUser(String userId, String password, String userName, Integer userSex) {
		UserDao dao = new UserDaoImpl();
		int row = 0;
		try {
			DBUtil.beginTransaction();
			row = dao.saveUser(userId,password,userName,userSex);
			if(row!=0){
				DBUtil.commitTransaction();
			}
		} catch (SQLException e) {
			DBUtil.rollbackTransaction();
			e.printStackTrace();
		}finally {
			DBUtil.close();
		}
		return row;
	}
}
