package com.les4.bd_student.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Teacher {
	public static void readTeacher(Statement statement, Connection connection) throws SQLException{
		String selectAllTeacher = "SELECT * FROM teacher";
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectAllTeacher);
		System.out.print("\n---------Table Teacher---------\n");
		System.out.format("%3s %-15s %-15s %-15s\n", "id", "lname", "fname", "mname");
		while (rs.next()) {
			int id = rs.getInt("id");
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			String mname = rs.getString("mname");
			System.out.format("%3d %-15s %-15s %-15s\n", id, lname, fname, mname);
		}
		rs.close();
	}
	
	public static void insertTeacher(PreparedStatement preparedStatement, Connection connection) throws SQLException{
		Scanner sc = new Scanner(System.in);
		String insertTeacher = "INSERT INTO teacher(lname, fname, mname) VALUES(?, ?, ?)";
		System.out.println("Input last name: ");
		String lastName = sc.nextLine();
		System.out.println("Input first name: ");
		String firstName = sc.nextLine();
		System.out.println("Input middle name: ");
		String middleName = sc.nextLine();
		preparedStatement = connection.prepareStatement(insertTeacher);
		preparedStatement.setString(1, lastName);
		preparedStatement.setString(2, firstName);
		preparedStatement.setString(3, middleName);
		preparedStatement.execute();
	}
	
	public static void updateTeacher(PreparedStatement preparedStatement, Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		String updateTeacher = "UPDATE teacher SET lname = ?, fname = ?, mname = ? WHERE id = ?";
		System.out.println("Input id what you want to update: ");
		int id = sc.nextInt();
		System.out.println("Input new last name: ");
		sc.nextLine();
		String newLastName = sc.nextLine();
		System.out.println("Input new first name: ");
		String newFirstName = sc.nextLine();
		System.out.println("Input new middle name: ");
		String newMiddleName = sc.nextLine();
		preparedStatement = connection.prepareStatement(updateTeacher);
		preparedStatement.setString(1, newLastName);
		preparedStatement.setString(2, newFirstName);
		preparedStatement.setString(3, newMiddleName);
		preparedStatement.setInt(4, id);
		preparedStatement.execute();
	}
}
