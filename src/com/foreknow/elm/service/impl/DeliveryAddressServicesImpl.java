package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.DeliveryAddressDao;
import com.foreknow.elm.dao.impl.DeliveryAddressDaoImpl;
import com.foreknow.elm.po.DeliveryAddress;
import com.foreknow.elm.service.DeliveryAddressServices;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class DeliveryAddressServicesImpl implements DeliveryAddressServices {
	@Override
	public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
		DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
		return dao.listDeliveryAddressByUserId(userId);
	}
	
	@Override
	public DeliveryAddress getDeliveryAddressById(Integer daId) {
		DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
		return dao.getDeliveryAddressById(daId);
	}
	
	@Override
	public int saveDeliveryAddress_updateDeliveryAddress(String contactName, Integer contactSex, String contactTel, String address, String userId,Integer...daId) {
		DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
		int row =0;
		try {
			DBUtil.beginTransaction();
			row = dao.saveDeliveryAddress_updateDeliveryAddress(contactName,contactSex,contactTel,address,userId,daId);
			if(row != 0){
				DBUtil.commitTransaction();
			}
		} catch (SQLException e) {
			DBUtil.rollbackTransaction();
			e.printStackTrace();
		}finally {
			DBUtil.close();
		}
		return row;
	}
	
	@Override
	public int removeDeliveryAddress(Integer daId) {
		DeliveryAddressDao dao = new DeliveryAddressDaoImpl();
		int row = 0;
		try {
			DBUtil.beginTransaction();
			row = dao.removeDeliveryAddress(daId);
			if(row != 0){
				DBUtil.commitTransaction();
			}
		} catch (SQLException e) {
			DBUtil.rollbackTransaction();
			e.printStackTrace();
		}finally {
			DBUtil.close();
		}
		return row;
	}
}
