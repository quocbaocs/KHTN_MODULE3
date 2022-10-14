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
<title>Thông tin khách hàng</title>
<style type="text/css">
table{
width: 800px;
margin: auto;
}
.content{
background-color: white;
}
.style3 {
	font-size: 25px;
	font-weight: bold;
	font-style: italic;
}

.tablekh {
	width: 100%;
	border: 1px solid black;
	align-items: center;
	margin: auto;
	padding: 0;
	border-collapse: collapse;
}
tr:nth-child(even){
	background-color: #ffe0c1;
}
td:nth-child(3){
	text-align: center;
}
tr, td {
	border: 1px solid black;
}
.tyle{
 	color: hotpink;
}

</style>
<%!
	String sql = "SELECT * FROM KHACH_HANG";
	Connection kn = CSDL.getKetNoi();
	Statement stm ;
	ResultSet rs ;
%>

</head>
<body>

<table>
		<tr valign="top">
			<td bgcolor="#aaa" width="100%" colspan="3">
				<jsp:directive.include file="header.jsp"/>
			</td>

			
		</tr>
		<tr valign="top">
			<td bgcolor="#aaa" width="20%">
			<%@include file="menu_trai.jsp" %>
			</td>

			<td bgcolor="#b5dcb3" height="200" width="60%" class="content">
			<jsp:include page="nav.jsp"></jsp:include>
				<%
	stm = kn.createStatement();
	rs = stm.executeQuery(sql);
		//XUAT THONG TIN KHI DA CO DU LIEU
		if(rs!=null){
	%>
		<p class='style3' align='center'>THÔNG TIN KHÁCH HÀNG</p>
		<table class="tablekh">
			<tr align='center' class="tyle">
				<td>Mã KH</td>
				<td>Tên khách hàng</td>
				<td>Giới tính</td>
				<td>Địa chỉ</td>
				<td>Số điện thoại</td>
			</tr>
		<% while(rs.next()){%>
			<tr>
				<td><%=rs.getString("ma_khach_hang") %></td>
				<td><%=rs.getString("ten_khach_hang") %></td>
				<td><img src="images/<%=rs.getBoolean("Phai")==true?"be_gai_2.jpg":"be_trai_1.jpg" %>" width="30px" height="30px"></td>
				<td><%=rs.getString("dia_chi") %></td>
				<td><%=rs.getString("dien_thoai") %></td>
			</tr>
		<%}%>
		</table>
	
	<%} %>
			</td>

			<td bgcolor="#aaa" width="20%">
			<jsp:directive.include file="menu_phai.jsp"/>
			</td>
		</tr>
		<tr valign="bottom" align="center" style="color: white;">
			<td bgcolor="# 1E90FF" width="100%" colspan="3">
				<jsp:directive.include file="footer.jsp"/>
			</td>

			
		</tr>
	</table>

	
</body>
</html>