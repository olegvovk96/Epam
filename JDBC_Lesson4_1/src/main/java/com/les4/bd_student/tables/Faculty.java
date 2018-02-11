package com.les4.bd_student.tables;

import java.sql.*;
import java.util.Scanner;


public class Faculty {
	public static void readFaculty(Statement statement, Connection connection) throws SQLException {
		String selectAllFaculty = "SELECT * FROM faculty";
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectAllFaculty);
		System.out.print("\n---------Table Faculty---------\n");
		System.out.println("id" + "\t" + "name");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id + "\t" +name);
		}
		rs.close();
	}
	
	public static void insertFaculty(PreparedStatement preparedStatement, Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		String insertFaculty = "INSERT INTO faculty(`name`) VALUES(?)";
		System.out.println("Input new name faculty: ");
		String newFaculty = sc.nextLine();
		preparedStatement = connection.prepareStatement(insertFaculty);
		preparedStatement.setString(1, newFaculty);
		preparedStatement.execute();
	}
	
	public static void updateFaculty(PreparedStatement preparedStatement, Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		String updateFaculty = "UPDATE faculty SET `name` = ? WHERE `name` = ?";
		System.out.println("Input name faculty what you want to update: ");
		String oldFaculty = sc.nextLine();
		System.out.println("Input new name faculty: ");
		String newFaculty = sc.nextLine();
		preparedStatement = connection.prepareStatement(updateFaculty);
		preparedStatement.setString(1, newFaculty);
		preparedStatement.setString(2, oldFaculty);
		preparedStatement.execute();
	}

}
