package com.les4.bd_student.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Point {
	public static void readPoint(Statement statement, Connection connection) throws SQLException{
		String selectAllPoint = "SELECT * FROM `point`";
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectAllPoint);
		System.out.print("\n---------Table Point---------\n");
		System.out.println("id" + "\t" + "semester" + "\t" + "module_1" + "\t" + "module_2" + 
								  "\t" + "100_point_scale" + "\t" + "5_point_scale");
		while (rs.next()) {
			int id = rs.getInt("id");
			int semester = rs.getInt("semester");
			int module_1 = rs.getInt("module_1");
			int module_2 = rs.getInt("module_2");
			int point_scale_100 = rs.getInt("100_point_scale");
			int point_scale_5 = rs.getInt("5_point_scale");
			System.out.println(id + "\t" + semester + "\t\t" + module_1 + "\t\t" + module_2 +
					                "\t\t" + point_scale_100 + "\t\t" + point_scale_5);
			
		}
		rs.close();
	}
	
	public static void insertPoint(PreparedStatement preparedStatement, Connection connection) throws SQLException{
		Scanner sc = new Scanner(System.in);
		String insertPoint = "INSERT INTO `point`(semester, module_1, module_2, 100_point_scale, 5_point_scale)"
				+ " VALUES(?, ?, ?, ?, ?)";
		System.out.println("Input semester: ");
		int semester = sc.nextInt();
		System.out.println("Input module_1: ");
		int module_1 = sc.nextInt();
		System.out.println("Input module_2: ");
		int module_2 = sc.nextInt();
		System.out.println("Input 100_point_scale: ");
		int pointScale_100 = sc.nextInt();
		System.out.println("Input 5_point_scale: ");
		int pointScale_5 = sc.nextInt();
		preparedStatement = connection.prepareStatement(insertPoint);
		preparedStatement.setInt(1, semester);
		preparedStatement.setInt(2, module_1);
		preparedStatement.setInt(3, module_2);
		preparedStatement.setInt(4, pointScale_100);
		preparedStatement.setInt(5, pointScale_5);
		preparedStatement.execute();
	}
	
	public static void updatePoint(PreparedStatement preparedStatement, Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input name of column what you want to update(semester, module_1, module_2, 100_point_scale, 5_point_scale ): ");
		String nameColumn = sc.nextLine();
		String updatePoint = "UPDATE point SET " + nameColumn + " = ? WHERE id = ?";
		System.out.println("Input id what you want to update: ");
		int id = sc.nextInt();
		System.out.println("Input new value: ");
		int newValue = sc.nextInt();
		preparedStatement = connection.prepareStatement(updatePoint);
		preparedStatement.setInt(1, newValue);
		preparedStatement.setInt(2, id);
		preparedStatement.execute();
	}
}
