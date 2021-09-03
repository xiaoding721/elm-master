package com.foreknow.elm.po;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryAddress {
	private int daId;
	private String contactName;
	private int contactSex;
	private String contactTel;
	private String address;
	private String userId;
	
	public DeliveryAddress getDeliveryAddressInfo(DeliveryAddress deliveryAddress, ResultSet rs) throws SQLException {
		deliveryAddress.daId = rs.getInt("daId");
		deliveryAddress.contactName = rs.getString("contactName");
		deliveryAddress.contactSex = rs.getInt("contactSex");
		deliveryAddress.contactTel = rs.getString("contactTel");
		deliveryAddress.address = rs.getString("address");
		deliveryAddress.userId = rs.getString("userId");
		return deliveryAddress;
	}
	public int getDaId() {
		return daId;
	}
	
	public String getContactName() {
		return contactName;
	}
	
	public int getContactSex() {
		return contactSex;
	}
	
	public String getContactTel() {
		return contactTel;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getUserId() {
		return userId;
	}
	

}
