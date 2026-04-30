package com.example.server.dao.config;

public class DatabaseUtil {
	public final static String DRIVER;
	public final static String BANK1_URL;
	public final static String BANK2_URL;
	public final static String BANK3_URL;
	public final static String USER_NAME;
	public final static String USER_PASSWORD;
	static{
		//DRIVER="com.mysql.jdbc.Driver";
		DRIVER="com.mysql.cj.jdbc.Driver";
		BANK1_URL="jdbc:mysql://localhost:3306/prj_se_bank1";
		BANK2_URL="jdbc:mysql://localhost:3306/prj_se_bank2";
		BANK3_URL="jdbc:mysql://localhost:3306/prj_se_bank3";
		USER_NAME="root";
		USER_PASSWORD="root";
	}
}

