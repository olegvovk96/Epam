package com.les4.bd_student.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentSubjectPoint {
	public static void readStudentSubjectPoint(Statement statement, Connection connection) throws SQLException{
		String selectAllSubjectTeacher = "SELECT " + "(SELECT lname FROM student WHERE student.id = ssp.student_id) AS student_name, "
							   + "(SELECT `name` FROM `subject` s WHERE s.id = ssp.subject_id) AS `name`, "
	                           + "(SELECT p.5_point_scale FROM point p WHERE p.id = ssp.point_id) AS 5_point_scale FROM student_subject_point ssp";
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectAllSubjectTeacher);
		System.out.print("\n---------Table Student_Subject_Point---------\n");
		 System.out.format("%-20s %-25s %-5s\n", "student_name", "subject", "5_point_scale");
		while (rs.next()) {
			String studantLastName = rs.getString("student_name");
			String subject = rs.getString("name");
			int point_scale_5 = rs.getInt("5_point_scale");
			System.out.format("%-20s %-25s %1d\n", studantLastName, subject, point_scale_5);
		}
		rs.close();
	}
}
