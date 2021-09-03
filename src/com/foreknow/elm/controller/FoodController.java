package com.foreknow.elm.controller;

import com.foreknow.elm.po.Food;
import com.foreknow.elm.service.FoodServices;
import com.foreknow.elm.service.impl.FoodServicesImpl;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FoodController {
	public List<Food> listFoodByBusinessId(HttpServletRequest request)throws Exception{
		Integer businessId = Integer.valueOf(request.getParameter("businessId"));
		FoodServices services = new FoodServicesImpl();
		return services.listFoodByBusinessId(businessId);
	}
}
