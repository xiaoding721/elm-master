package com.foreknow.elm.service;

import com.foreknow.elm.po.Business;

import java.util.List;

public interface BusinessService {
  /**
   * 根据orderTypeId查询商家信息
   *
   * @param orderTypeId 类型编号
   * @return List集合
   */
  List<Business> listBusinessByTypeId(Integer orderTypeId);
  
  /**
   * 根据businessId查询
   *
   * @param businessId 商家信息
   * @return Business对象
   */
  Business getBusinessById(Integer businessId);
}
