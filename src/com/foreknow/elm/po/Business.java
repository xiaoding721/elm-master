package com.foreknow.elm.po;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Business {
  //商家编号
  private Integer businessId;
  //商家名称
  private String businessName;
  //商家地址
  private String businessAddress;
  //商家介绍
  private String businessExplain;
  //商家图片（base64）
  private String businessImg;
  //点餐分类
  private Integer orderTypeId;
  //起送费
  private Double starPrice;
  //配送费
  private Double deliveryPrice;
  //备注
  private String remarks;
  
  //订单里的信息
  private List<OrderDetailet> orderDetailetList;
  public List<OrderDetailet> getOrderDetailetList() {
    if(this.orderDetailetList == null){
      this.orderDetailetList = new ArrayList<>();
    }
    return orderDetailetList;
  }
  
  public Business getBusinessInfo(Business business, ResultSet rs) throws SQLException {
    business.businessId=rs.getInt("businessId");
    business.businessName = rs.getString("businessName");
    business.businessAddress =rs.getString("businessAddress");
    business.businessExplain = rs.getString("businessExplain");
    business.businessImg = rs.getString("businessImg");
    business.orderTypeId = rs.getInt("orderTypeId");
    business.starPrice = rs.getDouble("starPrice");
    business.deliveryPrice = rs.getDouble("deliveryPrice");
    business.remarks = rs.getString("remarks");
    return business;
  }
  
  
  public Integer getBusinessId() {
    return businessId;
  }
  
  public String getBusinessName() {
    return businessName;
  }
  
  public String getBusinessAddress() {
    return businessAddress;
  }
  
  public String getBusinessExplain() {
    return businessExplain;
  }
  
  public String getBusinessImg() {
    return businessImg;
  }
  
  public Integer getOrderTypeId() {
    return orderTypeId;
  }
  
  public Double getStarPrice() {
    return starPrice;
  }
  
  public Double getDeliveryPrice() {
    return deliveryPrice;
  }
  
  public String getRemarks() {
    return remarks;
  }
  
}
