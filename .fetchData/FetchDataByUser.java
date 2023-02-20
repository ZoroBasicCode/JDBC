package org.Anime.narutoApp;

import java.sql.*;
import java.util.Scanner;

public class fetchDatat {


	public static void main(String[] args) throws SQLException
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id");
		int n=sc.nextInt();
		String qr="select * from uchiha.uchiha where id=?";
		sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("driver class is loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
			//System.out.println("connection is established");
			pstmt=con.prepareStatement(qr);
			//SET DATA FOR PLACE HOLDER//
			pstmt.setInt(1,n);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString("name");
				int kills=rs.getInt(3);
				System.out.println(id+" name "+name+" kills ="+kills);
			}
			else
				System.err.println("enter id="+n+" is not defined ");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    //closing all costly resources
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
