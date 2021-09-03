package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.Dao;
import com.foreknow.elm.dao.OrderDao;
import com.foreknow.elm.po.Orders;
import com.foreknow.elm.util.CommonUtil;
import com.foreknow.elm.util.DBUtil;
import com.mysql.jdbc.Statement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//检疫合格！！！！

public class OrderDaoImpl extends Dao implements OrderDao {
	@Override
	public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal) {
		String sql = "INSERT INTO orders (userId,businessId,orderTotal,daId,orderDate) values (?,?,?,?,?)";
		int orderId = 0;
		try {
			pst = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1,userId);
			pst.setInt(   2,businessId);
			pst.setDouble(3,orderTotal);
			pst.setInt(   4,daId);
			pst.setString(5, CommonUtil.getCurrentDate());
			pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			if (rs.next()){
				orderId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst);
		}
		return orderId;
	}
	
	@Override
	public Orders getOrdersById(Integer orderId) {
		String sql = "SELECT * FROM business,orders,orderdetailet where (orders.businessId=business.businessId AND orders.orderId = orderdetailet.orderId ) AND orders.orderId = ? ;";
		Orders orders = new Orders();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,orderId);
			rs = pst.executeQuery();
			while (rs.next()){
				orders = orders.getOrderInfo(orders,rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pst);
		}
		return orders;
	}
	
	@Override
	public List<Orders> listOrdersByUserId(String userId) {
		String sql = "SELECT * FROM business,orders,orderdetailet where (orders.businessId=business.businessId AND orders.orderId = orderdetailet.orderId ) AND orders.userId = ? ;";
		List<Orders> list = new ArrayList<>();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,userId);
			rs = pst.executeQuery();
			Orders orders1 = new Orders();
			Orders orders = null;
			boolean out = true;
			while (rs.next()){
				orders = new Orders();
				orders = orders.getOrderInfo(orders,rs);
				if(orders.getOrderId()==orders1.getOrderId()){
					orders1.getOrderInfo(orders1,rs);
					out=true;
				}else {
					list.add(orders1);
					orders1=orders;
					out=false;
				}
			}
			if(out){
				list.add(orders1);
			}else {
				list.add(orders);
			}
			list.remove(0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pst);
		}
		return list;
	}
}
