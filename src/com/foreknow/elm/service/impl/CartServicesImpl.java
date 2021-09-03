package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.CartDao;
import com.foreknow.elm.dao.impl.CartDaoImpl;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Cart;
import com.foreknow.elm.service.BusinessService;
import com.foreknow.elm.service.CartServices;
import com.foreknow.elm.service.FoodServices;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class CartServicesImpl implements CartServices {
	
	@Override
	public List<Cart> listCart(String userId,Integer businessId) {
		List<Cart> cartList = new CartDaoImpl().listCart(userId,businessId);    //新建一个购物车数组


		
		return cartList;
	}
	
	@Override
	public int saveCart_updateCart(Integer foodId, Integer businessId, String userId, Integer quantity,String operate) {
		CartDao dao = new CartDaoImpl();
		int row = 0;
		try {
			DBUtil.beginTransaction();
			row = dao.saveCart_updateCart(foodId, businessId, userId, quantity, operate);
			if (row != 0){
				DBUtil.commitTransaction();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollbackTransaction();
		} finally {
			DBUtil.close();
		}
		return row;
	}
	
	@Override
	public int removeCart(Integer businessId, String userId,Integer foodId) {
		CartDao dao = new CartDaoImpl();
		int row =0;
		try {
			DBUtil.beginTransaction();
			row = dao.removeCart(businessId, userId, foodId);
			if(row!= 0){
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
