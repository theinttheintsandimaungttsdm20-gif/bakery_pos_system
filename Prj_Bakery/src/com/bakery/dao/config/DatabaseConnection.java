package com.bakery.dao.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection openConnection(){
		try{
			Class.forName(DatabaseUtil.DRIVER);
			Connection con=DriverManager.getConnection(
					DatabaseUtil.URL,
					DatabaseUtil.USER_NAME,
					DatabaseUtil.USER_PASSWORD					
					);
			if(con!=null) return con;			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static void closeConnection(Connection c){
		try{
			c.close();
		}catch(Exception e){}
	}
	
}