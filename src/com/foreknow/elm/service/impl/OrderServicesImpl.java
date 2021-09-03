package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.CartDao;
import com.foreknow.elm.dao.OrderDao;
import com.foreknow.elm.dao.impl.CartDaoImpl;
import com.foreknow.elm.dao.impl.OrderDaoImpl;
import com.foreknow.elm.dao.impl.OrderDetailetDaoImpl;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Cart;
import com.foreknow.elm.po.Orders;
import com.foreknow.elm.service.OrderServices;
import com.foreknow.elm.util.DBUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderServicesImpl implements OrderServices {
	@Override
	/*
	 * OrdersController/createOrders
	 * 参数：userId、businessId、daId、orderTotal
	 * 返回值：int（订单编号）
	 * 功能：根据用户编号、商家编号、订单总金额、送货地址编号向订单表中添加一条记录，
	 * 并获取自动生成的订单编号，
	 * 然后根据用户编号、商家编号从购物车表中查询所有数据，批量添加到订单明细表中，
	 * 然后根据用户编号、商家编号删除购物车表中的数据。
	 */
	public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal) {
		int orderId = 0;
		try {
			DBUtil.beginTransaction();
			OrderDao orderdao = new OrderDaoImpl();
			orderId = orderdao.createOrders(userId, businessId, daId, orderTotal);
			if (orderId != 0) {
				int row = 0;
				CartDao cartDao = new CartDaoImpl();
				for (Cart cart : cartDao.listCart(userId, businessId)) {
					row += new OrderDetailetDaoImpl().addorderDetatilet(cart.getFoodId(), orderId, cart.getQuantity());
					row += cartDao.removeCart(businessId, userId, cart.getFoodId());
				}
				if(row !=0) {
					DBUtil.commitTransaction();
				}else {
					DBUtil.rollbackTransaction();
					orderId = 0;
				}
			}else {
				DBUtil.rollbackTransaction();
			}
		}catch (SQLException e){
			DBUtil.rollbackTransaction();
			e.printStackTrace();
		}finally {
			DBUtil.close();
		}
		return orderId;
	}
	//层级关系：
		//Orders：
			//Business：
				//OrderDetailet
	
	
	@Override
	public Orders getOrdersById(Integer orderId) {
		Orders orders = new OrderDaoImpl().getOrdersById(orderId);
		return orders_option(orders);
	}
	
	@Override
	public List<Orders> listOrdersByUserId(String userId) {
		List<Orders> ordersList = new ArrayList<>();
		for (Orders value :new OrderDaoImpl().listOrdersByUserId(userId)) {
				ordersList.add(orders_option(value));
		}
		return ordersList;
	}
	
	private Orders orders_option(Orders orders){
		List<Business> new_businessList = new ArrayList<>();
		Business business = new Business();
		for(Business busi:orders.getBusinessList()){
			if(Objects.equals(business.getBusinessId(), busi.getBusinessId())){
				business.getOrderDetailetList().add(busi.getOrderDetailetList().get(0));
			}else {
				new_businessList.add(business);
				business = busi;
			}
		}
		new_businessList.add(business);
		new_businessList.remove(0);
		orders.setNewBusinessList(new_businessList);
		return orders;
	}
	
}
