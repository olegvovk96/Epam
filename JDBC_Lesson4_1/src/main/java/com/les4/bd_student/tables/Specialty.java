package com.les4.bd_student.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Specialty {
	public static void readSpecialty(Statement statement, Connection connection) throws SQLException{
		String selectAllSpecialty = "SELECT * FROM specialty";
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectAllSpecialty);
		System.out.print("\n---------Table Specialty---------\n");
		System.out.println("id" + "\t" + "faculty_id" + "\t" + "name");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int facultyId = rs.getInt("faculty_id");
			System.out.println(id + "\t" + facultyId + "\t\t" + name);
		}
		rs.close();
	}
	
	public static void insertSpecialty(PreparedStatement preparedStatement, Connection connection) throws SQLException{
		Scanner sc = new Scanner(System.in);
		String insertSpecialty = "INSERT INTO specialty(`name`, faculty_id) VALUES(?, ?)";
		System.out.println("Input new name specialty: ");
		String newSpecialty = sc.nextLine();
		System.out.println("Input faculty_id: ");
		int facultyId = sc.nextInt();
		preparedStatement = connection.prepareStatement(insertSpecialty);
		preparedStatement.setString(1, newSpecialty);
		preparedStatement.setInt(2, facultyId);
		preparedStatement.execute();
	}
	
	public static void updateSpecialty(PreparedStatement preparedStatement, Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		StringBuilder newSpecialty = new StringBuilder();
		int facultyId = 0;
		System.out.println("Input name of column what you want to update(name, faculty_id): ");
		String nameColumn = sc.nextLine();
		String updateSpecialty = "UPDATE specialty SET " + nameColumn + " = ? WHERE id = ?";
		
		System.out.println("Input id what you want to update: ");
		int id = sc.nextInt();
		if(nameColumn.equals("name")){
			System.out.println("Input new specialty: ");
			sc.nextLine();
			newSpecialty.append(sc.nextLine());
		} else{
			System.out.println("Input new faculty_id: ");
			facultyId = sc.nextInt();
		}
		
		preparedStatement = connection.prepareStatement(updateSpecialty);
		if(nameColumn.equals("name")){
			preparedStatement.setString(1, newSpecialty.toString());
		} else{
			preparedStatement.setInt(1, facultyId);
		}		
		preparedStatement.setInt(2, id);
		preparedStatement.execute();
	}
	
}
