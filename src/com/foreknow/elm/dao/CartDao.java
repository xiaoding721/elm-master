package com.foreknow.elm.dao;

import com.foreknow.elm.po.Cart;

import java.sql.SQLException;
import java.util.List;

public interface CartDao {
	List<Cart> listCart(String userId,Integer businessId);
	
	int saveCart_updateCart(Integer foodId, Integer businessId, String userId, Integer quantity,String operate);
	
	int removeCart(Integer businessId, String userId,Integer foodId);
}
