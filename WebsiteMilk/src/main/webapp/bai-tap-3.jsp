<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="businessLogics.CSDL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài tập 3</title>
<style type="text/css">
img {
	width: 90px;
	height: 90px;
}

table {
	border-collapse: collapse;
}
</style>

<%!String sql = "select s.ten_sua, h.ten_hang_sua, l.ten_loai, s.trong_luong, s.don_gia, s.hinh from sua AS s INNER JOIN hang_sua AS h ON s.Ma_hang_sua = h.Ma_hang_sua INNER JOIN loai_sua AS l ON s.Ma_loai_sua = l.Ma_loai_sua";
	Connection kn = CSDL.getKetNoi();

	Statement stm;
	ResultSet rs;%>
<%
stm = kn.createStatement();
rs = stm.executeQuery(sql);
%>
</head>

<body>
<div align="center">
	<table border="1px">
		<tr>
		<td colspan="2" style="background-color: peachpuff; color: red;"><h1>THÔNG TIN CÁC SẢN PHẨM</h1></td>
		</tr>
	<% while (rs.next()) {
	%>
		<tr>
			<td><img alt="" src="images/sanpham/<%=rs.getString("hinh")%>"></td>
			<td>
			<b><%=rs.getString("ten_sua")%></b>
			<br/>
			<p>
			Nhà sản xuất: <%=rs.getString("ten_hang_sua") %><br>
			<%=rs.getString("ten_loai") %> - <%=rs.getInt("trong_luong") %> gr - <%=rs.getInt("don_gia") %> VNĐ</p>
			</td>
		</tr>

		<%
		}
		%>
	</table>
	</div>
</body>
</html>