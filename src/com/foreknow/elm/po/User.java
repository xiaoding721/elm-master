package com.foreknow.elm.po;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	private String userId;
	private String password;
	private String userName;
	private int userSex;
	private String userImg;
	private boolean delTag;
	
	public User getUserInfo(User user, ResultSet rs) throws SQLException {
		user.userId = rs.getString("userId");
		user.userName = rs.getString("userName");
		user.userSex = rs.getInt("userSex");
		user.userImg = rs.getString("userImg");
		return user;
	}
	
	
	public String getUserId() {
		return userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public int getUserSex() {
		return userSex;
	}
	
	public String getUserImg() {
		return userImg;
	}
	
	public boolean isDelTag() {
		return delTag;
	}
}
