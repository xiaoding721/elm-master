package com.foreknow.elm.dao;

import com.foreknow.elm.po.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressDao {
	List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
	
	DeliveryAddress getDeliveryAddressById(Integer daId);
	
	int saveDeliveryAddress_updateDeliveryAddress(String contactName, Integer contactSex, String contactTel, String address, String userId,Integer...daId);
	
	int removeDeliveryAddress(Integer daId);
}
