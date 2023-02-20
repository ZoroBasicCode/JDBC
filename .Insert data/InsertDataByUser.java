package org.Anime.narutoApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDataByUser 
{
public static void main(String[] args) throws SQLException 
{
	Connection con=null;
	PreparedStatement pstmt=null;
	Scanner sc=new Scanner(System.in);
	System.out.println("enter id number");
	int id=sc.nextInt();
	System.out.println("enter name");
	String name=sc.next();
	System.out.println("eneter kills");
	int kills=sc.nextInt();
	sc.close();
	String qr1="insert into uchiha.uchiha values(?,?,?)";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("driver is loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
		//System.out.println("connection is Establishe");
		pstmt=con.prepareStatement(qr1);
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, kills);
		pstmt.executeUpdate();
		System.out.println("data is inserted");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
}
}
