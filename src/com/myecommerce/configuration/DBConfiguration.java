package com.myecommerce.configuration;

import java.sql.Connection;
import java.sql.DriverManager;

import com.myecommerce.constant.ApplicationConstant;



public class DBConfiguration 
{
	public static Connection getConnection()
	{
		Connection conn=null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(ApplicationConstant .DB_URL,ApplicationConstant.DB_UserName,ApplicationConstant.DB_PassWord);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return conn;
	}
	

}
