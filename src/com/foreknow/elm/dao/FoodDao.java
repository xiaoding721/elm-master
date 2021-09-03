package com.foreknow.elm.dao;

import com.foreknow.elm.po.Food;

import java.util.List;

public interface FoodDao {
	List<Food> getFoodsByBusinessId(Integer businessId);
	
	Food getFoodById(Integer foodId);
}
