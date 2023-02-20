package org.Anime.narutoApp;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ep1 {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver is looad");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
			System.out.println("connecntion is established");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
