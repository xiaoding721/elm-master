package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.Dao;
import com.foreknow.elm.dao.FoodDao;
import com.foreknow.elm.po.Food;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl extends Dao implements FoodDao {
	@Override
	public List<Food> getFoodsByBusinessId(Integer businessId) {
		List<Food> list= new ArrayList<>();
		String sql = "SELECT * FROM food,business WHERE food.businessId=business.businessID AND business.businessId = ?;";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,businessId);
			rs = pst.executeQuery();
			while(rs.next()) {
				Food food = new Food();
				food = food.getFoodInfo(food,rs);
				list.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs,pst);
		}
		return list;
	}
	
	@Override
	public Food getFoodById(Integer foodId) {
		Food food = new Food();
		String sql = "select * FROM food WHERE foodId = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,foodId);
			rs = pst.executeQuery();
			if(rs.next()) {
				food = food.getFoodInfo(food,rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return food;
	}
}
