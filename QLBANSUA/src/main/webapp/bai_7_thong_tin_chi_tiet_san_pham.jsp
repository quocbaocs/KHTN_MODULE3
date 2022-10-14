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
<title>Thông tin chi tiết sản phẩm sữa</title>
<style type="text/css">
	.style49{
		align-content: center;
		width: 700px;
		margin:auto;
		padding:0;
		border: 3px solid brown;
		
	}
	.style35{
		text-align: center;
		height:60px;
		background-color: #ffeee6;
		font-size: 35px;
		color: red;
		font-weight: bold;
		font-family: serif;
		
	}
	.style37 > td{
	
		border: 1px solid gray;
		padding: 5px 10px;
		align-content: right;
	
	}
	span{
		word-spacing: 5;
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
		String sql = "SELECT * FROM SUA, LOAI_SUA, HANG_SUA "
		+"WHERE SUA.MA_LOAI_SUA = LOAI_SUA.MA_LOAI_SUA "
		+"AND SUA.MA_HANG_SUA = HANG_SUA.MA_HANG_SUA";
		Connection kn = CSDL.getKetNoi();
		Statement stm;
		ResultSet rs;
		int soDongTrang=2, tongSoTrang, trang = 1;
		Locale lc = new Locale("vi", "VN");
		NumberFormat nf = NumberFormat.getInstance();
		
		
		int currentPage;
%>
</head>
<body>
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
<h1>THÔNG TIN CHI TIẾT CÁC LOẠI SỮA</h1>
	<table class="style49">
	<%
	while(rs.next()){
	%>
		<tr>
			<td class="style35" colspan="2">
				<%=rs.getString("ten_sua") %> - <%=rs.getString("ten_hang_sua") %>
			</td>
		</tr>
		<tr class="style37">
			<td>
				<img alt="hinh" src="images/sanpham/<%=rs.getString("hinh")%>">
			</td>
			<td>
			<br>
				<b><i>Thành phần dinh dưỡng:</i></b><br>
				<%=rs.getString("tp_dinh_duong") %><br/>
				<b><i>Lợi ích:</i></b><br>
				<%=rs.getString("loi_ich") %>
				<p ><b><i>Trọng lượng:</i></b> <%=rs.getInt("trong_luong")%>  gr - <b><i>Đơn giá:</i></b> <%=nf.format(rs.getInt("don_gia")) %> VNĐ</p>
			</td>
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
			<a href="?page=<%=trang+1%>" >></a>&nbsp;<a href="?page=<%=tongSoTrang%>">>></a>
		</p>
		<%} %>

<%} %>
</body>
</html>