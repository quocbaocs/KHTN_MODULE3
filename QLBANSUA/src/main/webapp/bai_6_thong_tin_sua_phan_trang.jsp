<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.sql.PreparedStatement"%>
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
<title>Thông tin sữa</title>

<style type="text/css">

body {
	margin: auto;
	padding: 0;
}
table {
	width: 800px;
	border: 1px solid black;
	margin: auto;
	padding: 0;
	border-collapse: collapse;
}
tr, td {
	border: 1px solid black;
	padding: 10px;
}

tr:nth-child(odd){
	background-color: #ffe0c1;
	color: hotpink;
}
tr:nth-child(1){
	color: red;
	font-weight: bold;
}

h1{
 	color: red;
 	text-align: center;
}
a:active{
color: red;
}
a:link {
	color: black;
}
a:visited {
	color: black;
	font-weight: bold;
}
a:hover {
  color: hotpink;
}
</style>
<%!
	String sql = "SELECT * FROM SUA, LOAI_SUA, HANG_SUA WHERE SUA.MA_LOAI_SUA = LOAI_SUA.MA_LOAI_SUA "
	+"AND SUA.MA_HANG_SUA = HANG_SUA.MA_HANG_SUA";
	Connection kn = CSDL.getKetNoi();
	Statement stm;
	ResultSet rs;
	int soDongTrang=5, tongSoTrang, trang = 1;
	Locale lc = new Locale("vi", "VN");
	NumberFormat nf = NumberFormat.getInstance();
	
	
	int currentPage;
%>
</head>
<body>
	<h1>THÔNG TIN SỮA</h1>
	<%
	stm = kn.createStatement();
	rs = stm.executeQuery(sql);
	rs.last();
	int tsd = rs.getRow();
	tongSoTrang = tsd/soDongTrang + (tsd%soDongTrang!=1?1:0);;
	
	if(request.getParameter("page")!=null)
		trang = Integer.parseInt(request.getParameter("page"));
	int vt = (trang-1) * soDongTrang;
	rs = stm.executeQuery(sql + " limit " + vt + "," + soDongTrang);
	int stt= vt + 1;
	 
	 
	 rs.beforeFirst();
%>
<% if(rs!=null){
%>
	<table>
		<tr align="center">
			<td>Số STT</td>
			<td>Tên sữa</td>
			<td>Hãng sữa</td>
			<td>Loại sữa</td>
			<td>Trọng lượng</td>
			<td>Đơn giá</td>
		</tr>
		<%while(rs.next()){ %>
		<tr>
			<td><%=stt++%></td>
			<td><%=rs.getString("ten_sua")%></td>
			<td><%=rs.getString("ten_hang_sua") %>
			<td><%=rs.getString("ten_loai") %>
			<td><%=rs.getInt("trong_luong") %> gr</td>
			<td><%=nf.format(rs.getInt("don_gia")) %> VNĐ</td>
		</tr>
		<%} %>
	
	</table>
		<p align="center">
		<%if(trang>1) {%>
		<a href="?page=1"><<</a>&nbsp;<a href="?page=<%=trang+1%>"><</a>
		<%} %>
		
		<% for(int i=1; i <= tongSoTrang;i++){%>
			<a href="?page=<%=i%>" style="color: <%=trang==i?"red":"black"%>;"><%=i%></a>
		<%} %>
		
		<%if(trang<tongSoTrang) {%>
		<a href="?page=<%=trang+1%>" >></a>&nbsp;<a href="?page=<%=tongSoTrang%>">>></a></p>
		<%} %>

<%} %>
</body>
</html>