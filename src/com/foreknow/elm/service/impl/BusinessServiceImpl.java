package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.BusinessDao;
import com.foreknow.elm.dao.impl.BusinessDaoImpl;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.service.BusinessService;

import java.util.List;

public class BusinessServiceImpl implements BusinessService {
  @Override
  public List<Business> listBusinessByTypeId(Integer orderTypeId) {
    BusinessDao dao = new BusinessDaoImpl();
    return dao.listBusinessByOrderTypeId(orderTypeId);
  }

  @Override
  public Business getBusinessById(Integer businessId) {
    BusinessDao dao = new BusinessDaoImpl();
    return dao.getBusinessById(businessId);
  }
}
