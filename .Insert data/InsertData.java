package org.Anime.narutoApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData 
{
public static void main(String[] args) throws SQLException
{
	Connection con=null;
	PreparedStatement pstmt=null;
	String qr1="insert into uchiha.uchiha values(?,?,?)";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver is loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
		System.out.println("connection is established");
		pstmt=con.prepareStatement(qr1);
		System.out.println("platform is created");
		pstmt.setInt(1, 3);
		pstmt.setString(2, "sasuke");
		pstmt.setInt(3, 3000);
		pstmt.executeUpdate();
		System.out.println("data is inserted");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		if(pstmt!=null)
		{
			pstmt.close();
		}
		if(con!=null)
		{
			con.close();
		}
		
	}
}
}
