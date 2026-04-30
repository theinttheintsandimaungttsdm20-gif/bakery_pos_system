package com.bakery.dao.config;

public class DatabaseUtil {
	public final static String DRIVER;
	public final static String URL;
	public final static String USER_NAME;
	public final static String USER_PASSWORD;
	static{
		DRIVER="com.mysql.cj.jdbc.Driver";
		URL="jdbc:mysql://localhost:3306/prj_se_bakery";
		USER_NAME="root";
		USER_PASSWORD="root";
	}
}

