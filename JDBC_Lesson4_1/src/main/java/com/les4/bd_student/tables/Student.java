package com.les4.bd_student.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
	public static void readStudent(Statement statement, Connection connection) throws SQLException{
		String selectAllStudent = "SELECT * FROM student";
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectAllStudent);
		System.out.print("\n---------Table Student---------\n");
		System.out.format("%-7s %-15s %-15s %-15s %-15s %-20s %7s %10s %10s %7s %7s\n",
				"id", "lname", "fname", "mname", "birthDate", "homeAdress", "rating",
				"scholarshipSize", "admissionYear", "groupId", "specialtyId");
		while (rs.next()) {
			int id = rs.getInt("id");
			String lname = rs.getString("lname");
			String fname = rs.getString("fname");
			String mname = rs.getString("mname");
			Date birthDate = rs.getDate("birth_date");
			String homeAdress = rs.getString("home_adress");
			int rating = rs.getInt("rating");
			int scholarshipSize = rs.getInt("scholarship_size");
			int admissionYear = rs.getInt("year_of_admission");
			int groupId = rs.getInt("group_id");
			int specialtyId = rs.getInt("specialty_id");
			System.out.format("%-7d %-15s %-15s %-15s %-15s %-20s %7d %12d %12d %10d %10d\n",
					id, lname, fname, mname, birthDate, homeAdress, rating, scholarshipSize, admissionYear, groupId, specialtyId);
		}
		rs.close();
	}
	
	public static void insertStudent(PreparedStatement preparedStatement, Connection connection) throws SQLException{
		Scanner sc = new Scanner(System.in);
		String insertStudent = "INSERT INTO student(lname, fname, mname, birth_date, home_adress,"
				+ " rating, scholarship_size, year_of_admission, group_id, specialty_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
		System.out.println("Input last name: ");
		String lastName = sc.nextLine();
		System.out.println("Input first name: ");
		String firstName = sc.nextLine();
		System.out.println("Input middle name: ");
		String middleName = sc.nextLine();
		System.out.println("Input birth date in the format YYYY-MM-DD: ");
		String birthDate = sc.next(Pattern.compile("\\d{4}-\\d{2}-\\d{2}"));
		System.out.println("Input home adress: ");
		sc.nextLine();
		String homeAdress = sc.nextLine();
		System.out.println("Input rating: ");
		int rating = sc.nextInt();
		System.out.println("Input scholarship size: ");
		int scholarshipSize = sc.nextInt();
		System.out.println("Input year of admission: ");
		int admissionYear = sc.nextInt();
		System.out.println("Input group_id: ");
		int groupId = sc.nextInt();
		System.out.println("Input specialty_id: ");
		int specialtyId = sc.nextInt();
		preparedStatement = connection.prepareStatement(insertStudent);
		preparedStatement.setString(1, lastName);
		preparedStatement.setString(2, firstName);
		preparedStatement.setString(3, middleName);
		preparedStatement.setString(4, birthDate);
		preparedStatement.setString(5, homeAdress);
		preparedStatement.setInt(6, rating);
		preparedStatement.setInt(7, scholarshipSize);
		preparedStatement.setInt(8, admissionYear);
		preparedStatement.setInt(9, groupId);
		preparedStatement.setInt(10, specialtyId);
		preparedStatement.execute();
	}
	
	public static void updateStudent(PreparedStatement preparedStatement, Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		String updateFaculty = "UPDATE student SET lname = ?, fname = ?, mname = ?, birth_date = ?, "
				+ "home_adress = ?, rating = ?, scholarship_size = ?, year_of_admission = ?,"
				+ " group_id = ?, specialty_id = ?  WHERE id = ?";
		
		System.out.println("Input id what you want to update: ");
		int id = sc.nextInt();
		System.out.println("Input new last name: ");
		sc.nextLine();
		String newLastName = sc.nextLine();
		System.out.println("Input new first name: ");
		String newFirstName = sc.nextLine();
		System.out.println("Input new middle name: ");
		String newMiddleName = sc.nextLine();
		System.out.println("Input new birth date in the format YYYY-MM-DD: ");
		String newBirthDate = sc.next(Pattern.compile("\\d{4}-\\d{2}-\\d{2}"));
		System.out.println("Input new home adress: ");
		sc.nextLine();
		String newHomeAdress = sc.nextLine();
		System.out.println("Input new rating: ");
		int newRating = sc.nextInt();
		System.out.println("Input new scholarship size: ");
		int newScholarshipSize = sc.nextInt();
		System.out.println("Input new admission year: ");
		int newAdmissionYear = sc.nextInt();
		System.out.println("Input new group id: ");
		int newGroupId = sc.nextInt();
		System.out.println("Input new specialty id: ");
		int newSpecialtyId = sc.nextInt();
		
		preparedStatement = connection.prepareStatement(updateFaculty);
		preparedStatement.setString(1, newLastName);
		preparedStatement.setString(2, newFirstName);
		preparedStatement.setString(3, newMiddleName);
		preparedStatement.setString(4, newBirthDate);
		preparedStatement.setString(5, newHomeAdress);
		preparedStatement.setInt(6, newRating);
		preparedStatement.setInt(7, newScholarshipSize);
		preparedStatement.setInt(8, newAdmissionYear);
		preparedStatement.setInt(9, newGroupId);
		preparedStatement.setInt(10, newSpecialtyId);
		preparedStatement.setInt(11, id);
		preparedStatement.execute();
	}

}
