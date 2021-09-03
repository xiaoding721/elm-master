package com.foreknow.elm.controller;

import com.foreknow.elm.po.DeliveryAddress;
import com.foreknow.elm.service.DeliveryAddressServices;
import com.foreknow.elm.service.impl.DeliveryAddressServicesImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeliveryAddressController {
	public List<DeliveryAddress> listDeliveryAddressByUserId(HttpServletRequest request) throws Exception{
		String userId = request.getParameter("userId");
		DeliveryAddressServices deliveryAddressServices = new DeliveryAddressServicesImpl();
		return deliveryAddressServices.listDeliveryAddressByUserId(userId);
	}
	
	public DeliveryAddress getDeliveryAddressById(HttpServletRequest request) throws Exception{
		Integer daId = Integer.valueOf(request.getParameter("daId"));
		DeliveryAddressServices deliveryAddressServices = new DeliveryAddressServicesImpl();
		return deliveryAddressServices.getDeliveryAddressById(daId);
	}
	public int saveDeliveryAddress(HttpServletRequest request) throws Exception{
		String contactName =request.getParameter("contactName");
		Integer contactSex = Integer.valueOf(request.getParameter("contactSex"));
		String contactTel = request.getParameter("contactTel");
		String address = request.getParameter("address");
		String userId = request.getParameter("userId");
		DeliveryAddressServices deliveryAddressServices = new DeliveryAddressServicesImpl();
		return deliveryAddressServices.saveDeliveryAddress_updateDeliveryAddress(contactName,contactSex,contactTel,address,userId);
	}
	
	/*
	DeliveryAddressController/updateDeliveryAddress
	参数：daId、contactName、contactSex、contactTel、address、userId
	返回值：int（影响的行数）
	功能：根据送货地址编号更新送货地址信息
	 */
	public int updateDeliveryAddress(HttpServletRequest request) throws Exception{
		String contactName =request.getParameter("contactName");
		Integer daId = Integer.valueOf(request.getParameter("daId"));
		Integer contactSex = Integer.valueOf(request.getParameter("contactSex"));
		String contactTel = request.getParameter("contactTel");
		String address = request.getParameter("address");
		String userId = request.getParameter("userId");
		DeliveryAddressServices deliveryAddressServices = new DeliveryAddressServicesImpl();
		return deliveryAddressServices.saveDeliveryAddress_updateDeliveryAddress(contactName,contactSex,contactTel,address,userId,daId);
	}
	/*
	DeliveryAddressController/removeDeliveryAddress
	参数：daId
	返回值：int（影响的行数）
	功能：根据送货地址编号删除一条记录
	 */
	public int removeDeliveryAddress(HttpServletRequest request) throws Exception{
		Integer daId = Integer.valueOf(request.getParameter("daId"));
		DeliveryAddressServices deliveryAddressServices = new DeliveryAddressServicesImpl();
		return deliveryAddressServices.removeDeliveryAddress(daId);
	}
	
}
