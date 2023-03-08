<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%ResultSet rs=(ResultSet) session.getAttribute("std");
int id=rs.getInt(1);
String name=rs.getString(2);
long phon=rs.getLong(3);
String pasw=rs.getString(4);
%>
<form action="">
<table>
<tr><th>Student Details</th></tr>
<tr>
<td><label>Id</label></td>
<td><input type="text" value="<%=id%>"></td>
</tr>
<tr>
<td><label>Name</label></td>
<td><input type="text" value="<%=name%>"></td>
</tr>
<tr>
<td><label>Phone</label></td>
<td><input type="text" value="<%=phon%>"></td>
</tr>
<tr>
<td><label>Password</label></td>
<td><input type="text" value="<%=pasw%>"></td>
</tr>
</table>
</form>
</body>
</html>
