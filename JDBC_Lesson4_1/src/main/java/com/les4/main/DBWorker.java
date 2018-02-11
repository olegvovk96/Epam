package com.les4.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBWorker {
	public static final String URL="jdbc:mysql://localhost:3306/student_success?serverTimezone=UTC&useSSL=false";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	private Connection connection;
	
	public DBWorker(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}
	
}
