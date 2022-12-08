<%@page import="businessLogics.CSDL"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table style="width: 100%;background-color: orange;">
<%!Connection kn = CSDL.getKetNoi();
	Statement stm;
	ResultSet rs;
	PreparedStatement prstmt;
	String message = null;%>
	<%
	request.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
	%>
	<%
	stm = kn.createStatement();
	%>
	<tr>
		<th style="background-color: red; color: white;"><span>Sản
				phẩm theo hãng sữa</span></th>
	</tr>
	<%
						String qrHang = "SELECT * FROM HANG_SUA";
						rs = stm.executeQuery(qrHang);
						while (rs.next()) {%>
		<tr>
			<td><a href="?maHang=<%=rs.getString("ma_hang_sua")%>" ><%=rs.getString("Ten_hang_sua")%></a></td>
		</tr>
	<%} %>
	<tr>
		<th style="background-color: red; color: white;"><span>Sản
				phẩm theo loại</span></th>
	</tr>

	<%
						String qrLoai = "SELECT * FROM LOAI_SUA";
						rs = stm.executeQuery(qrLoai);
						while (rs.next()) {%>
		<tr>
			<td><a href="?maLoai=<%=rs.getString("ma_loai_sua")%>"><%=rs.getString("ten_loai")%></a></td>
		</tr>
	<%} %>
	<tr>
		<td><img src="images/menus/milk.jpg" width="100%" height="215px"></td>
	</tr>
</table>