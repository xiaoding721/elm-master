package com.foreknow.elm.service;

import com.foreknow.elm.po.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressServices {
	List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
	
	DeliveryAddress getDeliveryAddressById(Integer daId);
	
	int saveDeliveryAddress_updateDeliveryAddress(String contactName, Integer contactSex, String contactTel, String address, String userId,Integer...daId);
	
	int removeDeliveryAddress(Integer daId);
}
