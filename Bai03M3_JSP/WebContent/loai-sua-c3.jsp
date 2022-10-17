
<%@page import="dataTransferObject.LoaiSua"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loại sữa C3</title>
<%
	List<LoaiSua> dsls = (List<LoaiSua>)request.getAttribute("dsls");
%>
</head>
<body>
<table border="1">
	<caption>DANH SÁCH LOẠI SỮA</caption>
	<tr>
		<th>Mã loại</th>
		<th>Tên loại</th>
	</tr>
	<%for(LoaiSua ls:dsls){ %>
		<tr>
			<td><%=ls.getMaLoaiSua() %></td>
			<td><%=ls.getTenLoaiSua() %></td>
		</tr>
	<%} %>
</table>
</body>
</html>