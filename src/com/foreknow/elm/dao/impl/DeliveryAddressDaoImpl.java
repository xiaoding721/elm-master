package com.foreknow.elm.dao.impl;


import com.foreknow.elm.dao.Dao;
import com.foreknow.elm.dao.DeliveryAddressDao;
import com.foreknow.elm.po.DeliveryAddress;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressDaoImpl extends Dao implements DeliveryAddressDao {
	
	@Override
	public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
		List<DeliveryAddress> list = new ArrayList<>();
		String sql;
		try {
			sql = "select * from deliveryaddress where userId=? ;";
			pst = con.prepareStatement(sql);
			pst.setString(1, userId);
			rs = pst.executeQuery();
			while (rs.next()) {
				DeliveryAddress deliveryAddress = new DeliveryAddress();
				deliveryAddress = deliveryAddress.getDeliveryAddressInfo(deliveryAddress, rs);
				list.add(deliveryAddress);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst);
		}
		return list;
	}
	
	@Override
	public DeliveryAddress getDeliveryAddressById(Integer daId) {
		String sql = "select * from deliveryaddress where daId = ? ;";
		DeliveryAddress deliveryAddress = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, daId);
			rs = pst.executeQuery();
			if (rs.next()) {
				deliveryAddress = new DeliveryAddress();
				deliveryAddress = deliveryAddress.getDeliveryAddressInfo(deliveryAddress, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst);
		}
		return deliveryAddress;
	}
	
	@Override
	public int saveDeliveryAddress_updateDeliveryAddress(String contactName, Integer contactSex, String contactTel, String address, String userId, Integer... daId) {
		int row = 0;
		String sql;
		try {
			if (daId.length == 0) {
				sql = "insert into deliveryaddress(contactName, contactSex, contactTel, address, userId) VALUES (?,?,?,?,?);";
				pst = con.prepareStatement(sql);
			} else {
				sql = "update deliveryaddress set contactName = ? ,contactSex = ? ,contactTel = ?,address = ? where userId = ? and daId = ?;";
				pst = con.prepareStatement(sql);
				pst.setInt(6, daId[0]);
			}
			pst.setString(1, contactName);
			pst.setInt(2, contactSex);
			pst.setString(3, contactTel);
			pst.setString(4, address);
			pst.setString(5, userId);
			row = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pst);
		}
		return row;
	}
	
	@Override
	public int removeDeliveryAddress(Integer daId) {
		int row = 0;
		String sql = "delete from deliveryaddress where daId = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, daId);
			row = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pst);
		}
		return row;
	}
}
