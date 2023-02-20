package org.Anime.narutoApp;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadAndRigesterDriver {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver is looad");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
