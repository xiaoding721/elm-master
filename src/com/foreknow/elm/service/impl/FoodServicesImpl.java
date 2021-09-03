package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.FoodDao;
import com.foreknow.elm.dao.impl.FoodDaoImpl;
import com.foreknow.elm.po.Food;
import com.foreknow.elm.service.FoodServices;

import java.util.List;

public class FoodServicesImpl implements FoodServices {
	
	@Override
	public List<Food> listFoodByBusinessId(Integer businessId) {
		FoodDao foodDao = new FoodDaoImpl();
		return foodDao.getFoodsByBusinessId(businessId);
	}
	
	@Override
	public Food getFoodById(Integer foodId) {
		FoodDao foodDao = new FoodDaoImpl();
		return foodDao.getFoodById(foodId);
	}
}
