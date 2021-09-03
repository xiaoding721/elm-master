package com.foreknow.elm.po;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orders {
	private int orderId;
	private Date orderDate;
	private double orderTotal;
	private int daId;
	private int orderState;
	
	
	private List<Business> businessList;
	public List<Business> getBusinessList() {
		if(this.businessList == null){
			this.businessList = new ArrayList<>();
		}
		return businessList;
	}
	public void setNewBusinessList(List<Business> list){
		this.businessList = list;
	}
	
	public Orders getOrderInfo(Orders orders, ResultSet rs) throws SQLException {
		orders.orderId = rs.getInt("orderId");
		orders.orderDate = rs.getDate("orderDate");
		orders.orderTotal = rs.getDouble("orderTotal");
		orders.daId = rs.getInt("daId");
		orders.orderState = rs.getInt("orderState");
		
		OrderDetailet orderdetailet = new OrderDetailet();
		orderdetailet = orderdetailet.getOrderDetailetInfo(orderdetailet, rs);
		
		Business business = new Business();
		business = business.getBusinessInfo(business, rs);
		
		business.getOrderDetailetList().add(orderdetailet);
		orders.getBusinessList().add(business);
		
		return orders;
	}
	
	
	public int getOrderId() {
		return orderId;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public double getOrderTotal() {
		return orderTotal;
	}
	
	public int getDaId() {
		return daId;
	}
	
	public int getOrderState() {
		return orderState;
	}
}
