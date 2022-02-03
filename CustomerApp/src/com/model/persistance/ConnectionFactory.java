package com.model.persistance;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	public static Connection getConnection() {
		Connection connection = null;
		InputStream inputStream = null;
		Properties properties = new Properties();
		try {
			inputStream = new FileInputStream("db.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			throw new MyException(e);
		}
		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));
		} catch (SQLException e) {
			throw new MyException(e);
		}

		return connection;

	}

}