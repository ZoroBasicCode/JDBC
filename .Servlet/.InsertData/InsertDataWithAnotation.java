package org.SRK.Insert;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fs")
public class InsertData extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("i"));
		String name=req.getParameter("nm");
		long phon=Long.parseLong(req.getParameter("ph"));
		String pasw=req.getParameter("ps");
		
		Connection con=null;
		String qr="insert into jdbc.student values(?,?,?,?)";
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
			
			pstmt=con.prepareStatement(qr);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setLong(3, phon);
			pstmt.setString(4, pasw);
			pstmt.executeUpdate();
			
			System.out.println("data is inserted with id "+id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		PrintWriter writer=resp.getWriter();
		writer.write("<html><body>");
		writer.write("<h1> welcom  "+name+" with id :"+id+"</h1></body></html>");
	
	}
}
