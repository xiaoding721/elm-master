package com.foreknow.elm.controller;

import com.foreknow.elm.service.BusinessService;
import com.foreknow.elm.service.impl.BusinessServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class BusinessController {
  /**
   * 根据orderTypeId查询商家的信息
   * @param request HttpServletRequest
   * @return Object(list extends Object)
   */
  public Object listBusinessByOrderTypeId(HttpServletRequest request)throws Exception{
    //获取请求参数 BusinessController/listBusinessByOrderTypeId?orderTypeId=1
    Integer orderTypeId = Integer.valueOf(request.getParameter("orderTypeId"));
    //调用service的方法
    BusinessService service = new BusinessServiceImpl();
    return service.listBusinessByTypeId(orderTypeId);
  }

  /**
   * 根据businessId查询某一个商家的信息
   * @param request HttpServletRequest
   * @return Business对象
   */
  public Object getBusinessById(HttpServletRequest request) throws Exception{
    Integer businessId = Integer.valueOf(request.getParameter("businessId"));
    BusinessService service = new BusinessServiceImpl();
    return service.getBusinessById(businessId);
  }


}
