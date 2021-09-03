package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.Dao;
import com.foreknow.elm.dao.UserDao;
import com.foreknow.elm.po.User;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;

public class UserDaoImpl extends Dao implements UserDao {
	@Override
	public User getUserByIdByPass(String userId, String password) {
		String sql = "SELECT * FROM user where userId = ? AND password = ?;";
		User user = null;
		try {
			//获取连接
			
			pst = con.prepareStatement(sql);
			pst.setString(1,userId);
			pst.setString(2,password);
			rs = pst.executeQuery();
			if (rs.next()){
				user = new User();
				user = user.getUserInfo(user,rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pst);
		}
		return user;
	}
	
	@Override
	public int getUserById(String userId) {
		String sql = "select COUNT(*) from user WHERE userId = ?";
		int count_user = 0;
		try {
			//获取连接
			
			pst = con.prepareStatement(sql);
			pst.setString(1,userId);
			rs = pst.executeQuery();
			if (rs.next()){
				count_user = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pst);
		}
		return count_user;
	}
	
	@Override
	public int saveUser(String userId, String password, String userName, Integer userSex) {
		String sql = "INSERT INTO user (userId,password, userName, userSex,delTag) values (?,?,?,?,1)";
		int row = 0;
		try {
			//获取连接
			
			pst = con.prepareStatement(sql);
			pst.setString(1,userId);
			pst.setString(2,password);
			pst.setString(3,userName);
			pst.setInt(4,userSex);
			row = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pst);
		}
		return row;
	}
}
