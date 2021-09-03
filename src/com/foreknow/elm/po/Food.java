package com.foreknow.elm.po;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Food {
	private int foodId;
	private String foodName;
	private String foodExplain;
	private String foodImg;
	private int foodPrice;
	private int businessId;
	private String remarks;
	
	public Food getFoodInfo(Food food, ResultSet rs) throws SQLException {
		food.foodId = rs.getInt("foodId");
		food.foodName = rs.getString("foodName");
		food.foodExplain = rs.getString("foodExplain");
		food.foodImg = rs.getString("foodImg");
		food.foodPrice = rs.getInt("foodPrice");
		food.businessId = rs.getInt("businessId");
		food.remarks = rs.getString("remarks");
		return food;
	}
	
	public int getFoodId() {
		return foodId;
	}
	
	public String getFoodName() {
		return foodName;
	}
	
	public String getFoodExplain() {
		return foodExplain;
	}
	
	public String getFoodImg() {
		return foodImg;
	}
	
	public int getFoodPrice() {
		return foodPrice;
	}
	
	public int getBusinessId() {
		return businessId;
	}
	
	public String getRemarks() {
		return remarks;
	}
}
