package com.foreknow.elm.util;

public class test {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select c.*, ");
		sql.append("        f.foodId ffoodId, ");
		sql.append("        f.foodName ffoodName, ");
		sql.append("        f.foodExplain ffoodExplain, ");
		sql.append("        f.foodImg ffoodImg, ");
		sql.append("        f.foodPrice ffoodPrice, ");
		sql.append("        f.businessId fbusinessId, ");
		sql.append("        f.remarks fremarks, ");
		sql.append("        b.businessId bbusinessId, ");
		sql.append("        b.businessName bbusinessName, ");
		sql.append("        b.businessAddress bbusinessAddress, ");
		sql.append("        b.businessExplain bbusinessExplain, ");
		sql.append("        b.businessImg bbusinessImg, ");
		sql.append("        b.orderTypeId borderTypeId, ");
		sql.append("        b.starPrice bstarPrice, ");
		sql.append("        b.deliveryPrice bdeliveryPrice");
		sql.append(" from (cart c left join food f on c.foodId=f.foodId) ");
		sql.append("      left join business b on c.businessId=b.businessId ");
		sql.append(" where 1=1 ");
		System.out.println(sql
		);
	}
}
