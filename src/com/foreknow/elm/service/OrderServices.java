package com.foreknow.elm.service;

import com.foreknow.elm.po.Orders;

import java.util.List;

public interface OrderServices {
	int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal);
	
	Orders getOrdersById(Integer orderId);
	
	List<Orders> listOrdersByUserId(String userId);
}
