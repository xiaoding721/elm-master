package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.Dao;
import com.foreknow.elm.dao.OrderDetailetDao;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;

public class OrderDetailetDaoImpl extends Dao implements OrderDetailetDao {
	@Override
	public int addorderDetatilet(Integer foodId, Integer orderId, Integer quantity) {
		String sql = "INSERT INTO orderdetailet (orderId,foodId, quantity) values (?,?,?)";
		int row = 0;
			try {
				//获取连接
				
				pst = con.prepareStatement(sql);
				pst.setInt(1,orderId);
				pst.setInt(2,foodId);
				pst.setInt(3,quantity);
				row = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(pst);
			}
		return row;
	}
}
