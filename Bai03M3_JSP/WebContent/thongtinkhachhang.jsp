<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="businessLogics.CSDL"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin khách hàng</title>
<%!
	Connection kn = CSDL.getKetNoi();
	Statement stm;
	ResultSet rs;
	String sql = "select * from khach_hang";
	
	%>
	<%
		stm =kn.createStatement();
		rs = stm.executeQuery(sql);
	%>
<style type="text/css">

div {
  text-align: center;
}
table {
    margin: 0 auto; /* or margin: 0 auto 0 auto */
    border-collapse: collapse;
  }
  img{
  	height: 30px;
  	width:30px; 
  }
  td:nth-child(3) {
	text-align: center;	
}
tr:nth-child(even) {
	background-color: khaki;
}
</style>
</head>
<body>
	<div>
	<h1>THÔNG TIN KHÁCH HÀNG</h1>
		<table border="1">
		<tr>
			<th>Mã KH</td>
			<th>Tên khách hàng</th>
			<th>Giới tính</th>
			<th>Địa chỉ</th>
			<th>Điện thoại</th>
		</tr>
		<%while(rs.next()){ %>
		<tr>
			<td><%=rs.getString("Ma_khach_hang") %></td>
			<td><%=rs.getString("Ten_khach_hang") %></td>
			<td><img src="images/<%=rs.getBoolean("Phai")?"be_trai_1.jpg":"be_gai_2.jpg"%>"></td>
			<td><%=rs.getString("dia_chi") %></td>
			<td><%=rs.getString("dien_thoai") %></td>
			
		</tr>
		
	<%} %>
		</table>
	
	</div>

</body>
</html>