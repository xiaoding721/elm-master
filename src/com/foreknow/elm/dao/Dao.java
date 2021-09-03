package com.foreknow.elm.dao;


import com.foreknow.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Dao {
	protected final Connection con;
	protected PreparedStatement pst = null;
	protected ResultSet rs = null;
	protected Dao(){
		con = DBUtil.getConnection();
	}
}
