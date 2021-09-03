package com.foreknow.elm.po;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cart {
	private int cartId;
	private int foodId;
	private int businessId;
	private String userId;
	private int quantity;
	private Food food;
	private Business business;
	public Food getFood() {
		return food;
	}
	public Business getBusiness() {
		return business;
	}
	
	public Cart getCartInfo(Cart cart, ResultSet rs) throws SQLException {
		cart.cartId = rs.getInt("cartId");
		cart.foodId = rs.getInt("foodId");
		cart.businessId = rs.getInt("businessId");
		cart.userId = rs.getString("userId");
		cart.quantity = rs.getInt("quantity");
		Food food = new Food();
		Business business = new Business();
		cart.food = food.getFoodInfo(food,rs);
		cart.business = business.getBusinessInfo(business,rs);
		return cart;
	}
	
	public int getCartId() {
		return cartId;
	}
	public int getFoodId() {
		return foodId;
	}
	public int getBusinessId() {
		return businessId;
	}
	public String getUserId() {
		return userId;
	}
	public int getQuantity() {
		return quantity;
	}
}
