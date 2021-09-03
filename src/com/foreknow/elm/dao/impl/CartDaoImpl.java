package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.CartDao;
import com.foreknow.elm.dao.Dao;
import com.foreknow.elm.po.Cart;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl extends Dao implements CartDao {
	@Override
	public List<Cart> listCart(String userId,Integer businessId) {
		List<Cart> list = new ArrayList<>();
		String sql;
		try {
			//获取连接
			if(businessId==null){
				sql = " select * from (cart left join food on cart.foodId=food.foodId) left join business on cart.businessId=business.businessId  where cart.userId = ?";
				pst = con.prepareStatement(sql);//insert into emp values(?,?,?,?)
			}else {
				sql = " select * from (cart left join food on cart.foodId=food.foodId) left join business on cart.businessId=business.businessId  where cart.userId = ? AND cart.businessId = ?";
				pst = con.prepareStatement(sql);//insert into emp values(?,?,?,?)
				pst.setInt(2,businessId);
			}
			pst.setString(1,userId);
			rs = pst.executeQuery();
			while(rs.next()) {
				Cart cart = new Cart();
				cart = cart.getCartInfo(cart,rs);
				list.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs,pst);
		}
		return list;
	}
	
	@Override
	public int saveCart_updateCart(Integer foodId, Integer businessId, String userId, Integer quantity,String operate) {
		String sql = null;
		int row =0;
		switch (operate) {
			case "saveCart" -> sql = "INSERT INTO cart (quantity,foodId, businessId, userId) values (?,?,?,?)";
			case "updateCart" -> sql = "update cart set quantity= ? where foodId = ? AND businessId = ? AND userId = ?;";
		}
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,quantity);
			pst.setInt(2,foodId);
			pst.setInt(3,businessId);
			pst.setString(4,userId);
			row = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pst);
		}
		return row;
	}
	
	@Override
	public int removeCart(Integer businessId, String userId, Integer foodId) {
		String sql;
		int row = 0;
		try {
			if(foodId == null){
				sql = "delete from cart where businessId = ? AND userId = ? ;";
				pst = con.prepareStatement(sql);
			}else {
				sql = "delete from cart where businessId = ? AND userId = ? AND foodId = ?;";
				pst = con.prepareStatement(sql);
				pst.setInt(3,foodId);
			}
			pst.setInt(1,businessId);
			pst.setString(2,userId);
			row = pst.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.close(pst);
		}
		return row;
	}
	
}
