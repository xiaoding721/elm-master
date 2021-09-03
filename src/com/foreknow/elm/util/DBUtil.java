package com.foreknow.elm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	private static final String URL = "jdbc:mysql://10.25.244.93:3306/xiaoding3?characterEncoding=utf-8";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private static final ThreadLocal<Connection> TL = new ThreadLocal<>();

    //获取Connection
    public static synchronized Connection getConnection() {
	    Connection con = TL.get();
    	if(con==null) {
    		con = createConnection();
    		TL.set(con);
    	}
    	return con;
    }

    //开启一个事务
    public static void beginTransaction() throws SQLException {
	    Connection con = TL.get();
    	if(con==null) {
    		con = createConnection();
    		TL.set(con);
    	}
    	//开启一个事务
    	con.setAutoCommit(false);
    }

    //提交一个事务
    public static void commitTransaction(){
    	Connection con = TL.get();
	    try {
		    con.commit();
	    } catch (SQLException e) {
		    e.printStackTrace();
	    }
    }

    //回滚一个事务
    public static void rollbackTransaction(){
    	Connection con = TL.get();
	    try {
		    con.rollback();
	    } catch (SQLException e) {
		    e.printStackTrace();
	    }
    }

    //关闭资源
    public static void close(ResultSet rs,PreparedStatement pst) {
    	try {
    		if(rs!=null) {
				rs.close();
    		}
    		if(pst!=null) {
    			pst.close();
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public static void close(PreparedStatement pst) {
    	try {
    		if(pst!=null) {
    			pst.close();
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public static void close() {
    	Connection con = TL.get();
    	try {
    		if(con!=null) {
    			con.close();
    		}
    		//必须要remove，否则会造成内存泄漏问题。
    		TL.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    private static Connection createConnection() {
    	Connection con = null;
	    try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return con;
    }

}
