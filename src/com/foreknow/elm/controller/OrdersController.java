package com.foreknow.elm.controller;



import com.foreknow.elm.po.Orders;
import com.foreknow.elm.service.OrderServices;
import com.foreknow.elm.service.impl.OrderServicesImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class OrdersController {
	/*
	 * OrdersController/createOrders
	 * 参数：userId、businessId、daId、orderTotal
	 * 返回值：int（订单编号）
	 * 功能：根据用户编号、商家编号、订单总金额、送货地址编号向订单表中添加一条记录，
	 * 并获取自动生成的订单编号，
	 * 然后根据用户编号、商家编号从购物车表中查询所有数据，批量添加到订单明细表中，
	 * 然后根据用户编号、商家编号删除购物车表中的数据。
	 */
	public int createOrders(HttpServletRequest request)throws Exception{
		String userId = request.getParameter("userId");
		Integer businessId = Integer.valueOf(request.getParameter("businessId"));
		Integer daId = Integer.valueOf(request.getParameter("daId"));
		Double orderTotal = Double.valueOf(request.getParameter("orderTotal"));
		OrderServices orderServices = new OrderServicesImpl();
		return orderServices.createOrders(userId,businessId,daId,orderTotal);
	}
	/*
	 * OrdersController/getOrdersById
	 * 参数：orderId
	 * 返回值：orders对象（包括多对一：商家信息； 一对多：订单明细信息）
	 * 功能：根据订单编号查询订单信息，包括所属商家信息，和此订单的所有订单明细信息
	 */
	public Orders getOrdersById(HttpServletRequest request)throws Exception{
		Integer orderId = Integer.valueOf(request.getParameter("orderId"));
		OrderServices orderServices = new OrderServicesImpl();
		return orderServices.getOrdersById(orderId);
	}
	/*
	 * OrdersController/listOrdersByUserId
	 * 参数：userId
	 * 返回值：orders数组（包括多对一：商家信息； 一对多：订单明细信息）
	 * 功能：根据用户编号查询此用户的所有订单信息
	 */
	public List<Orders> listOrdersByUserId(HttpServletRequest request)throws Exception{
		String userId = request.getParameter("userId");
		OrderServices orderServices = new OrderServicesImpl();
		return orderServices.listOrdersByUserId(userId);
	}
}
