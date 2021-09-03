package com.foreknow.elm.dao;

import com.foreknow.elm.po.Orders;

import java.util.List;

public interface OrderDao {
	int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal);
	
	Orders getOrdersById(Integer orderId);
	
	List<Orders> listOrdersByUserId(String userId);
}
