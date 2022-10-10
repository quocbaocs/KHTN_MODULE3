<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="businessLogics.CSDL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="businessLogics.CSDL"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài tập 4</title>
<style type="text/css">

img {
	width: 90px;
	height: 90px;
}

td{
	width:180px;
	vertical-align: top;
	text-align: center; 
}
th{
	background-color: peachpuff; 
	color: red; 
	text-align: center;
	height: 30px;
	font-size: 30px;
}
</style>
<%!String sql = "select s.ten_sua, h.ten_hang_sua, l.ten_loai, s.trong_luong, s.don_gia, s.hinh from sua AS s INNER JOIN hang_sua AS h ON s.Ma_hang_sua = h.Ma_hang_sua INNER JOIN loai_sua AS l ON s.Ma_loai_sua = l.Ma_loai_sua";
	Connection kn = CSDL.getKetNoi();

	Statement stm;
	ResultSet rs;
	Locale lc = new Locale("vi","VN");
	
	NumberFormat fn = NumberFormat.getNumberInstance();
	
	
	%>
<%
stm = kn.createStatement();
rs = stm.executeQuery(sql);
int sc=1;
%>
</head>
<body>
<div align="center">
<table border="1">
	<tr>
		<th colspan="5">THÔNG TIN CÁC SẢN PHẨM</th>
	</tr>
	<%
	while(rs.next()){
		%>
		<%if(sc++==1){ %>
		<tr>
		<%} %>
		<td><b><%=rs.getString("ten_sua") %></b><br>
		<%=rs.getString("ten_loai") %> - <%=rs.getInt("trong_luong") %> gr - <%=fn.format(rs.getInt("don_gia") ) %> VNĐ<br/>
		<img alt="" src="images/sanpham/<%=rs.getString("hinh")%>"></td>
		
		<%if(sc==6){ %>
		<%sc=1; %>
		</tr>
		<%} %>
		
	<!--  	<%if(sc!=1){ %>
		</tr>
		<%} %>
		-->
		
	
	<%} %>
</table>
</div>
</body>
</html>