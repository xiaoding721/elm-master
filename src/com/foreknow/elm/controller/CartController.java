package com.foreknow.elm.controller;

import com.foreknow.elm.po.Cart;
import com.foreknow.elm.service.CartServices;
import com.foreknow.elm.service.impl.CartServicesImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CartController {
	/*
	CartController/listCart
	参数：userId、businessId（可选）
	返回值：cart数组（多对一：所属商家信息、所属食品信息）
	功能：根据用户编号查询此用户所有购物车信息
	根据用户编号和商家编号，查询此用户购物车中某个商家的所有购物车信息
	*/
	public List<Cart> listCart(HttpServletRequest request) throws Exception{
		Integer businessId = null;
		try {
			businessId = Integer.valueOf(request.getParameter("businessId"));  //可能为空
		}catch (Exception ignored){}
		String userId = request.getParameter("userId");
		CartServices cartServices = new CartServicesImpl();
		return cartServices.listCart(userId,businessId);
	}
	
	public int saveCart(HttpServletRequest request) throws Exception{
		Integer businessId = Integer.valueOf(request.getParameter("businessId"));
		String userId = request.getParameter("userId");
		Integer foodId = Integer.valueOf(request.getParameter("foodId"));
		String operate = "saveCart";
		CartServices cartServices = new CartServicesImpl();
		return cartServices.saveCart_updateCart(foodId,businessId,userId,1,operate);
	}
	
	public int updateCart(HttpServletRequest request) throws Exception{
		Integer businessId = Integer.valueOf(request.getParameter("businessId"));
		String userId = request.getParameter("userId");
		Integer foodId = Integer.valueOf(request.getParameter("foodId"));
		Integer quantity = Integer.valueOf(request.getParameter("quantity"));
		String operate = "updateCart";
		CartServices cartServices = new CartServicesImpl();
		return cartServices.saveCart_updateCart(foodId,businessId,userId,quantity,operate);
	}
	
	public int removeCart(HttpServletRequest request) throws Exception{
		Integer foodId = null;
		Integer businessId = Integer.valueOf(request.getParameter("businessId"));
		String userId = request.getParameter("userId");
		try{
			foodId = Integer.valueOf(request.getParameter("foodId")); //可能为空
		}catch (Exception ignored){}
		CartServices cartServices = new CartServicesImpl();
		return cartServices.removeCart(businessId,userId,foodId);
	}
}
