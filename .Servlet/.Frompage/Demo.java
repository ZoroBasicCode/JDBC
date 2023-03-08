package org.SRK;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//@WebServlet("/fs")
public class Demo extends GenericServlet{
	public Demo() {
		System.out.println("object is created");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("object is initialized");
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("i"));
		String name=req.getParameter("nm");
		String dept=req.getParameter("dp");
		long phon=Long.parseLong(req.getParameter("ph"));
		PrintWriter out=resp.getWriter();
		out.println("<html><body><h1> id :"+id+"  name :"+name+"</h1></body></html>");
		out.close();
		System.out.println("service() is executed");
	}
}
