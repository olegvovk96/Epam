package com.les4.main;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.les4.bd_student.tables.*;



public class Main {
	
	public static void main(String[] args) {
	DBWorker db = new DBWorker();
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	try {
		boolean isRun = true;
		Scanner sc = new Scanner(System.in);
		while(isRun){
			System.out.println("Enter 0 to exit");
			System.out.println("Enter 1 to SHOW tables");
			System.out.println("Enter 2 to INSERT colums of tables");
			System.out.println("Enter 3 to UPDATE colums of tables");
			System.out.println("Enter 4 to DELETE colums of tables");
			switch (sc.nextInt()) {
			case 1: {
				System.out.println("Enter 0 to exit");
				System.out.println("Enter 1 to SHOW Faculty table");
				System.out.println("Enter 2 to SHOW Group table");
				System.out.println("Enter 3 to SHOW Point table");
				System.out.println("Enter 4 to SHOW Specialty table");
				System.out.println("Enter 5 to SHOW Student table");
				System.out.println("Enter 6 to SHOW Subject table");
				System.out.println("Enter 7 to SHOW Teacher table");
				System.out.println("Enter 8 to SHOW Subject_Teacher table");
				System.out.println("Enter 9 to SHOW Student_Subject_Point table");
				switch (sc.next()) {
				case "1": {
					Faculty.readFaculty(statement, db.getConnection());
					break;
				}
				case "2": {
					Group.readGroup(statement, db.getConnection());
					break;
				}
				case "3": {
					Point.readPoint(statement, db.getConnection());
					break;
				}
				case "4": {
					Specialty.readSpecialty(statement, db.getConnection());
					break;
				}
				case "5": {
					Student.readStudent(statement, db.getConnection());
					break;
				}
				case "6": {
					Subject.readSubject(statement, db.getConnection());
					break;
				}
				case "7": {
					Teacher.readTeacher(statement, db.getConnection());
					break;
				}			
				case "8": {
					SubjectTeacher.readSubjectTeacher(statement, db.getConnection());
					break;
				}
				case "9": {
					StudentSubjectPoint.readStudentSubjectPoint(statement, db.getConnection());
					break;
				}
				}					
				break;
			}
			case 2: {
				System.out.println("Enter 0 to exit");
				System.out.println("Enter 1 to INSERT colums of Faculty table");
				System.out.println("Enter 2 to INSERT colums of Group table");
				System.out.println("Enter 3 to INSERT colums of Point table");
				System.out.println("Enter 4 to INSERT colums of Specialty table");
				System.out.println("Enter 5 to INSERT colums of Student table");
				System.out.println("Enter 6 to INSERT colums of Subject table");
				System.out.println("Enter 7 to INSERT colums of Teacher table");
				switch (sc.next()) {
				case "1":{	
					Faculty.insertFaculty(preparedStatement, db.getConnection());
					break;
				}
				case "2":{
					Group.insertGroup(preparedStatement, db.getConnection());
					break;
				}
				case "3":{
					Point.insertPoint(preparedStatement, db.getConnection());
					break;
				}
				case "4":{
					Specialty.insertSpecialty(preparedStatement, db.getConnection());
					break;
				}
				case "5":{
					Student.insertStudent(preparedStatement, db.getConnection());
					break;
				}
				case "6":{
					Subject.insertSubject(preparedStatement, db.getConnection());
					break;
				}
				case "7":{
					Teacher.insertTeacher(preparedStatement, db.getConnection());
					break;
				}
				}
				break;
			}
			case 3: {
				System.out.println("Enter 0 to exit");
				System.out.println("Enter 1 to UPDATE colum of Faculty table");
				System.out.println("Enter 2 to UPDATE colum of Group table");
				System.out.println("Enter 3 to UPDATE colum of Point table");
				System.out.println("Enter 4 to UPDATE colum of Specialty table");
				System.out.println("Enter 5 to UPDATE colum of Student table");
				System.out.println("Enter 6 to UPDATE colum of Subject table");
				System.out.println("Enter 7 to UPDATE colum of Teacher table");
				switch (sc.next()) {
				case "1":{
					Faculty.updateFaculty(preparedStatement, db.getConnection());
					break;
				}
				case "2":{
					Group.updateGroup(preparedStatement, db.getConnection());
					break;
				}
				case "3":{
					Point.updatePoint(preparedStatement, db.getConnection());
					break;
				}
				case "4":{
					Specialty.updateSpecialty(preparedStatement, db.getConnection());
					break;
				}
				case "5":{
					Student.updateStudent(preparedStatement, db.getConnection());
					break;
				}
				case "6":{
					Subject.updateSubject(preparedStatement, db.getConnection());
					break;
				}
				case "7":{
					Teacher.updateTeacher(preparedStatement, db.getConnection());
					break;
				}
				
				}
				break;
			}
			case 4: {
				System.out.println("Enter 0 to exit");
				System.out.println("Enter 1 to choose table");
				GeneralDelete.showNameTables();
				switch (sc.next()) {
				case "1":
					System.out.println("Input name table from list:");
					sc.nextLine();
					String deleteRowFromTable = sc.nextLine();
					GeneralDelete.delete(preparedStatement, db.getConnection(), deleteRowFromTable);
					break;
				}
				break;
			}
			default:
				sc.close();
				isRun = false;
				break;
			}
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	finally {
		if(db.getConnection() != null){
			try {
				db.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(statement != null) { 
			try { 
				statement.close(); 
			} catch (SQLException e) { 
				e.printStackTrace(); 
			}
		}
		else if(preparedStatement != null) { 
			try { 
				preparedStatement.close(); 
			} catch (SQLException e) { 
				e.printStackTrace(); 
			}
		}
	}
 }
}
