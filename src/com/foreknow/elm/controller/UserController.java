package com.foreknow.elm.controller;

import com.foreknow.elm.po.User;
import com.foreknow.elm.service.UserServices;
import com.foreknow.elm.service.impl.UserServicesImpl;

import javax.servlet.http.HttpServletRequest;

public class UserController {
	/*
	 * UserController/getUserByIdByPass
	 * 参数：userId、password
	 * 返回值：user对象
	 * 功能：根据用户编号与密码查询用户信息
	 */
	public User getUserByIdByPass(HttpServletRequest request)throws Exception{
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		UserServices userServices =new UserServicesImpl();
		return userServices.getUserByIdByPass(userId,password);
	}
	/*
	 * UserController/getUserById
	 * 参数：userId
	 * 返回值：int（返回行数）
	 * 功能：根据用户编号查询用户表返回的行数
	 */
	public int getUserById(HttpServletRequest request)throws Exception{
		String userId = request.getParameter("userId");
		UserServices userServices =new UserServicesImpl();
		return userServices.getUserById(userId);
	}
	
	 /*
	 * UserController/saveUser
	 * 参数：userId、password、userName、userSex
	 * 返回值：int（影响的行数）
	 * 功能：向用户表中添加一条记录
	 */
	 public int saveUser(HttpServletRequest request)throws Exception{
		 String userId = request.getParameter("userId");
		 String password = request.getParameter("password");
		 String userName = request.getParameter("userName");
		 int userSex = Integer.parseInt(request.getParameter("userSex"));
		 UserServices userServices =new UserServicesImpl();
		 return userServices.saveUser(userId,password,userName,userSex);
	 }
}
