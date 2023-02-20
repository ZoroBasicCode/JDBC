package org.Anime.narutoApp;

import java.sql.*;
import java.util.Scanner;

public class fetchString {


	public static void main(String[] args) throws SQLException
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the name");
		String nam=sc.nextLine();
		String qr="select * from uchiha.uchiha where name=?";
		sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("driver class is loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
			//System.out.println("connection is established");
			pstmt=con.prepareStatement(qr);
			//SET DATA FOR PLACE HOLDER//
			pstmt.setString(1, nam);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int kills=rs.getInt(3);
				System.out.println("id= "+id+" name = "+name+" kills ="+kills);
			}
			else
				System.err.println("enter id="+nam+" is not defined ");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    //CLOSING ALL COSTELY RESOURCES 
	finally {
		if(rs!=null)
		{
			rs.close();
		}
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
