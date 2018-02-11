package com.les4.bd_student.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Subject {
	public static void readSubject(Statement statement, Connection connection) throws SQLException{
		String selectAllSubject = "SELECT * FROM subject";
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectAllSubject);
		System.out.print("\n---------Table Subject---------\n");
		System.out.println("id" + "\t" + "name");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id + "\t" +name);
		}
		rs.close();
	}
	
	public static void insertSubject(PreparedStatement preparedStatement, Connection connection) throws SQLException{
		Scanner sc = new Scanner(System.in);
		String insertSubject = "INSERT INTO subject(`name`) VALUES(?)";
		System.out.println("Input new name subject: ");
		String newSubject = sc.nextLine();
		preparedStatement = connection.prepareStatement(insertSubject);
		preparedStatement.setString(1, newSubject);
		preparedStatement.execute();
	}
	
	public static void updateSubject(PreparedStatement preparedStatement, Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		String updateSubject = "UPDATE subject SET `name` = ? WHERE `name` = ?";
		System.out.println("Input subject what you want to update: ");
		String oldSubject = sc.nextLine();
		System.out.println("Input new subject: ");
		String newSubject = sc.nextLine();
		preparedStatement = connection.prepareStatement(updateSubject);
		preparedStatement.setString(1, newSubject);
		preparedStatement.setString(2, oldSubject);
		preparedStatement.execute();
	}
	
}
