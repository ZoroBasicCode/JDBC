package org.SRK.Valid;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/fs")
public class Validation extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long phon=Long.parseLong(req.getParameter("ph"));
		String pasw=req.getParameter("ps");
		
		Connection con=null;
		String qr="select * from jdbc.student where phon=? and pasw=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
			pstmt=con.prepareStatement(qr);
			pstmt.setLong(1, phon);
			pstmt.setString(2, pasw);
			rs=pstmt.executeQuery();
			RequestDispatcher dispatcher=null;
			PrintWriter writer=resp.getWriter();
			if(rs.next())
			{
				HttpSession session=req.getSession();
				session.setAttribute("std", rs);
				dispatcher=req.getRequestDispatcher("Valid.jsp");
				dispatcher.forward(req, resp);
			}
			else {
				writer.write("<html><body><h1> invalid password </h1></body></html>");
				dispatcher=req.getRequestDispatcher("Form.html");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
