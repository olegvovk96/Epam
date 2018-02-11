package com.les4.bd_student.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SubjectTeacher {
	public static void readSubjectTeacher(Statement statement, Connection connection) throws SQLException{
		String selectAllSubjectTeacher = "SELECT " + "(SELECT `name` FROM `subject` s WHERE s.id = st.subject_id) AS `name`, "
	                           + "(SELECT lname FROM teacher t WHERE t.id = st.teacher_id) AS lname FROM subject_teacher st";
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectAllSubjectTeacher);
		System.out.print("\n---------Table Subject_Teacher---------\n");
		 System.out.format("%-40s %s\n", "subject", "teacher_lname");
		while (rs.next()) {
			String subject = rs.getString("name");
			String lname = rs.getString("lname");
			System.out.format("%-40s %s\n", subject, lname);
		}
		rs.close();
	}
}
