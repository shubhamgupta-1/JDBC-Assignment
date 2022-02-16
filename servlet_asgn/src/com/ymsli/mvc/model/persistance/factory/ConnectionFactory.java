package com.ymsli.mvc.model.persistance.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static Connection connection=null;
	public static Connection getConnection() {
		Properties properties=new Properties();
		InputStream is=null;
		
		try {
			is=ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(properties.getProperty("jdbc.url"),properties.getProperty("jdbc.username"),properties.getProperty("jdbc.password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
		
	}

}
