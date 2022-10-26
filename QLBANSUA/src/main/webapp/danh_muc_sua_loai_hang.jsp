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
table{
margin: auto;
}
</style>
<%!
	String sql = "SELECT * FROM SUA, LOAI_SUA, HANG_SUA WHERE SUA.MA_LOAI_SUA = LOAI_SUA.MA_LOAI_SUA "
	+"AND SUA.MA_HANG_SUA = HANG_SUA.MA_HANG_SUA ";
	Connection kn;
	Statement stm;
	ResultSet rs;
	int soDongTrang=8, tongSoTrang, trang = 1;
	Locale lc = new Locale("vi", "VN");
	NumberFormat nf = NumberFormat.getInstance();
	
	
	int currentPage;
%>
</head>
<body>
	<h3 align="center">DANH MỤC SẢN PHẨM</h3>
	<%
	if(request.getParameter("maloai")!=null){
		sql = sql+" AND SUA.MA_LOAI_SUA ='"+request.getParameter("maloai")+"'";
	}
	if(request.getParameter("mahang")!=null){
		sql += " AND SUA.MA_HANG_SUA ='"+request.getParameter("mahang")+"'";
	}
	
	kn = CSDL.getKetNoi();
		
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
		<tr align="center" bgcolor=" #ffe0c1" style="font-weight: bold;">
			<td>Hình</td>
			<td>Tên sữa</td>
			<td>Trọng lượng <br>(gr)</td>
			<td>Đơn giá<br> (VNĐ)</td>
		</tr>
		<%while(rs.next()){ %>
		<tr>
			<td><img src="images/sanpham/<%=rs.getString("hinh")%>" style="width: 30px; height: 30px;"></td>
			<td><a href="chi_tiet_san_pham.jsp?masua=<%=rs.getString("ma_sua")%>"><%=rs.getString("ten_sua")%></a></td>
			<td><%=rs.getInt("trong_luong") %> gr</td>
			<td><%=nf.format(rs.getInt("don_gia")) %> VNĐ</td>
		</tr>
		<%} %>
	
	</table>
		<p align="center">
		
		<a href="?page=1">&lt;&lt;</a>&nbsp;<a href="?page=<%=trang-1<1?trang:trang-1%>">&lt;</a>
		
		<% for(int i=1; i <= tongSoTrang;i++){%>
			<a href="?page=<%=i%>" style="color: <%=trang==i?"red":"black"%>;"><%=i%></a>
		<%} %>
		
		<a href="?page=<%=trang+1>tongSoTrang?tongSoTrang:trang+1%>">&gt;</a>&nbsp;<a href="?page=<%=tongSoTrang%>">&gt;&gt;</a>

<%} %>
</body>
</html>