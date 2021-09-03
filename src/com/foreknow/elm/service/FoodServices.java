package com.foreknow.elm.service;

import com.foreknow.elm.po.Food;

import java.util.List;

public interface FoodServices {
	List<Food> listFoodByBusinessId(Integer businessId);
	
	Food getFoodById(Integer foodId);
}
