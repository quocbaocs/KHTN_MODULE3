<%@page import="com.mysql.fabric.xmlrpc.base.Param"%>
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
table {
	margin: auto;
	border:1px solid black;
	border-collapse: collapse;
}
table tr td {
	border: 1px solid black;
}
tr:nth-child(even) {
	background-color: orange;
}

</style>


<%
String sql = "SELECT * FROM KHACH_HANG";
//Connection kn = CSDL.getKetNoi();
//Statement stm ;
//ResultSet rs ;
int result;
String message = null;
String sqlSelect = "SELECT * FROM KHACH_HANG,HOA_DON WHERE HOA_DON.MA_KHACH_HANG=KHACH_HANG.MA_KHACH_HANG AND HOA_DON.MA_KHACH_HANG= '";
%>

</head>
<body>


	<!-- Content -->
	<%
	Connection kn = CSDL.getKetNoi();
	Statement stm;
	ResultSet rs;
	%>
	<%
	stm = kn.createStatement();
	%>

	<h2 align='center'>THÔNG TIN KHÁCH HÀNG</h2>
	<%
	if (request.getParameter("message") != null) {
	%>
	<p align="center">
		<b><%=request.getParameter("message")%></b>
	</p>
	<%
	}
	%>

	<%
	if (request.getParameter("makh") != null) {
		rs = stm.executeQuery(sqlSelect + request.getParameter("makh") + "'");
		if (rs.next()) {
	%>
	<p align="center" style="color: red;">
		<b>Khách hàng,<%=rs.getString("ten_khach_hang")%> đã mua hàng nên
			không thể xóa được.
		</b>
	</p>
	<%
	} else {
	String delete = "DELETE FROM KHACH_HANG WHERE MA_KHACH_HANG='" + request.getParameter("makh") + "'";
	stm.executeUpdate(delete);
	%>
	<p align="center">
		<b>Đã xóa thông tin khách hàng</b>
	</p>




	<%
	}
	%>
	<%
	}
	%>


	<%
	rs = stm.executeQuery(sql);
	%>
	<%
	//XUAT THONG TIN KHI DA CO DU LIEU
	if (rs.next()) {
	%>

	<table class="tblkh">
		<tr align='center' style="color: hotpink;">
			<td>Mã KH</td>
			<td>Tên khách hàng</td>
			<td>Giới tính</td>
			<td>Địa chỉ</td>
			<td>Số điện thoại</td>
			<td><img alt="" src="images/but_sua.png"></td>
			<td><img alt="" src="images/but_xoa.png"></td>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("ma_khach_hang")%></td>
			<td><%=rs.getString("ten_khach_hang")%></td>
			<td><%=rs.getBoolean("phai") != true ? "Nam" : "Nữ"%></td>
			<td><%=rs.getString("dia_chi")%></td>
			<td><%=rs.getString("dien_thoai")%></td>
			<td><a
				href="cap_nhat_khach_hang.jsp?makh=<%=rs.getString("ma_khach_hang")%>">Sửa</a></td>
			<td><a href="?makh=<%=rs.getString("ma_khach_hang")%>">Xóa</a></td>
		</tr>
		<%
		}
		%>
	</table>

	<%
	}
	%>



	





</body>
</html>