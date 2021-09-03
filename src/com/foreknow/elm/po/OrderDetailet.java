package com.foreknow.elm.po;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailet {
	private int odId;
	private int orderId;
	private int foodId;
	private int quantity;
	
	public OrderDetailet getOrderDetailetInfo(OrderDetailet orderdetailet, ResultSet rs) throws SQLException {
		orderdetailet.odId = rs.getInt("odId");
		orderdetailet.orderId = rs.getInt("orderId");
		orderdetailet.foodId = rs.getInt("foodId");
		orderdetailet.quantity = rs.getInt("quantity");
		return orderdetailet;
	}
	
	public int getOdId() {
		return odId;
	}
	public int getOrderId() {
		return orderId;
	}
	public int getFoodId() {
		return foodId;
	}
	public int getQuantity() {
		return quantity;
	}
}
