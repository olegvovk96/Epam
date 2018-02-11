package com.les4.bd_student.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class GeneralDelete {
	
	public static void showNameTables(){
		for(Table t : Table.values()){
			System.out.print(t.name().toLowerCase() + "  ");
		}
	}
	
	public static void delete(PreparedStatement preparedStatement, Connection connection, String nameTable) throws SQLException {
		Scanner sc = new Scanner(System.in);
		String  deleteRow = "DELETE FROM `" + nameTable + "` WHERE id = ?";
		System.out.println("Input id what you want to delete: ");
		int id = sc.nextInt();
		preparedStatement = connection.prepareStatement(deleteRow);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
	}
}
