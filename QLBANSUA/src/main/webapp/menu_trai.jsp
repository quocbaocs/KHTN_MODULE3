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
<style type="text/css">
.title{
color: white;
background-color: Brown;
}
.tblmenu{
background-color: DarkOrange;
width: 170px;
}
ul{
list-style: none;
margin: 0;
padding: 0;
}

</style>
<%	Connection kn= CSDL.getKetNoi();;
	Statement stm;
	ResultSet rs;
%>
</head>
<body>
<%
	stm = kn.createStatement();
%>
	<table class="tblmenu">
		<tr class="title">
			<td>Sản phẩm theo hãng sữa</td>
		</tr>
		<tr>
			<td>
			<ul>
			<%
		    String qrHang ="SELECT * FROM HANG_SUA";
			rs=stm.executeQuery(qrHang);
			
		    while(rs.next()){ %>
		    	<li><a href="danh_muc_san_pham_link.jsp?mahang=<%=rs.getString("ma_hang_sua") %>"><%=rs.getString("ten_hang_sua") %></a></li>
		    <%} %>
		    </ul>
			</td>
		</tr>
		<tr class="title">
			<td>Sản phẩm theo loại</td>
		</tr>
		<tr>
			<td>
			<ul>
			<%
		    String qrLoai ="SELECT * FROM LOAI_SUA";
			rs=stm.executeQuery(qrLoai);
			
		    while(rs.next()){ %>
		    	<li><a href="danh_muc_san_pham_link.jsp?maloai=<%=rs.getString("ma_loai_sua") %>"><%=rs.getString("ten_loai") %></a></li>
		    <%} %>
		    </ul>
			</td>
		</tr>
		<tr></tr>
		<tr >
		<td>
		<img alt="" src="images/menu/milk.jpg" width="170px" style="margin-top: 15px;">
		</td>
		</tr>
		
	</table>
	
</body>
</html>