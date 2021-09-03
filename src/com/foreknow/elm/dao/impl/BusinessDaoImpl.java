package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.BusinessDao;
import com.foreknow.elm.dao.Dao;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl extends Dao implements BusinessDao {
	@Override
	public List<Business> listBusinessByOrderTypeId(Integer orderTypeId){
		List<Business> list = new ArrayList<>();
		String sql = "select * from business where orderTypeId=? order by businessId";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,orderTypeId);
			rs = pst.executeQuery();
			while(rs.next()) {
				Business business = new Business();
				business = business.getBusinessInfo(business,rs);
				list.add(business);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs,pst);
		}
		return list;
	}
	
	@Override
	public Business getBusinessById(Integer businessId){
		Business business = null;
		String sql = "select * from business where businessId=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,businessId);
			rs = pst.executeQuery();
			if(rs.next()) {
				business = new Business();
				business = business.getBusinessInfo(business,rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs,pst);
		}
		return business;
	}
}
