package org.StanLee.marvel;

import java.sql.*;
import java.util.Scanner;

public class FetchDataBYNameOrId
{
	public static void main(String[] args) throws SQLException 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("fetch data by id enter 1");
		System.out.println("fetch data by name enter 2");
		int n=sc.nextInt();
		if(n==1)
		{
		Connection con =null;
		PreparedStatement pstmt=null;
		
		System.out.println("enter the id");
		int i=sc.nextInt();
		String qr="select * from marvel.avengers where id=?";
		ResultSet rs=null;
		sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("driver class is loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
			//System.out.println("connection is Established");
			pstmt=con.prepareStatement(qr);
			pstmt.setInt(1, i);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String power=rs.getString(3);
				System.out.println("id ="+id+" name = "+name+" power = "+power);
				
			}
			else
				System.out.println(" entered id ="+i+" not defined");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
	}
		if(n==2)
		{
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			System.out.println("enter the name");
			String nam=sc.next();
			String qr="select * from marvel.avengers where name=?";
			sc.close();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//System.out.println("driver class is loaded");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
				//System.out.println("connectionn is established");
				pstmt=con.prepareStatement(qr);
				//SET DATA FOR PLACE HOLDER//
				pstmt.setString(1, nam);
				rs=pstmt.executeQuery();
				if(rs.next())
				{
					int id=rs.getInt(1);
					String name=rs.getString(2);
					String power=rs.getNString(3);
					int kills=rs.getInt(4);
					System.out.println("id= "+id+" name = "+name+" power = "+power+" kills ="+kills);
				}
				else
					System.out.println("enter the valid name");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
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
}
