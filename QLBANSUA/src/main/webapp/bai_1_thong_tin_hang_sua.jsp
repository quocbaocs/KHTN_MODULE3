<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="businessLogics.CSDL"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lưới thô hãng sữa</title>
<style type="text/css">
.style4 {
	font-size: 20px;
	font-weight: bold;
	font-style: italic;
	color: rgb(0, 72, 155);
}

table {
	width: 700px;
	border: 1px solid black;
	align-items: center;
	margin: auto;
	padding: 0;
	border-collapse: collapse;
}
td:nth-child(3){
	text-align: center;
}

tr,th, td {
	border: 1px solid;
}
</style>
<%
	String sql = "SELECT * FROM HANG_SUA";
	Connection kn = CSDL.getKetNoi();
	Statement stm ;
	ResultSet rs ;
%>

</head>
<body>
	<%
	stm = kn.createStatement();
	rs = stm.executeQuery(sql);
		//XUAT THONG TIN KHI DA CO DU LIEU
		if(rs!=null){
	%>
		<p class='style4' align='center'>THÔNG TIN HÃNG SỮA</p>
		<table>
			<tr align='center'>
				<td>Mã HS</td>
				<td>Tên hãng sữa</td>
				<td>Địa chỉ</td>
				<td>Điện thoại</td>
				<td>Email</td>
			</tr>
		<% while(rs.next()){%>
			<tr>
				<td><%=rs.getString("ma_hang_sua") %></td>
				<td><%=rs.getString("ten_hang_sua") %></td>
				<td><%=rs.getString("dia_chi") %></td>
				<td><%=rs.getString("dien_thoai") %></td>
				<td><%=rs.getString("email") %></td>
			</tr>
		<%}%>
		</table>
	
	<%} %>
</body>
</html>