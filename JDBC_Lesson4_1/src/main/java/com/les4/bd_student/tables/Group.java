package com.les4.bd_student.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Group {
	public static void readGroup(Statement statement, Connection connection) throws SQLException{
		String selectAllGroup = "SELECT * FROM `group`";
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectAllGroup);
		System.out.print("\n---------Table Group---------\n");
		System.out.println("id" + "\t" + "name");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id + "\t" +name);
		}
		rs.close();
	}
	
	public static void insertGroup(PreparedStatement preparedStatement, Connection connection) throws SQLException{
		Scanner sc = new Scanner(System.in);
		String insertGroup = "INSERT INTO `group`(`name`) VALUES(?)";
		System.out.println("Input new name group: ");
		String newGroup = sc.nextLine();
		preparedStatement = connection.prepareStatement(insertGroup);
		preparedStatement.setString(1, newGroup);
		preparedStatement.executeUpdate();
	}
	
	public static void updateGroup(PreparedStatement preparedStatement, Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		String updateGroup = "UPDATE `group` SET `name` = ? WHERE `name` = ?";
		System.out.println("Input name group what you want to update: ");
		String oldGroup = sc.nextLine();
		System.out.println("Input new name group: ");
		String newGroup = sc.nextLine();
		preparedStatement = connection.prepareStatement(updateGroup);
		preparedStatement.setString(1, newGroup);
		preparedStatement.setString(2, oldGroup);
		preparedStatement.execute();
	}
	
}
