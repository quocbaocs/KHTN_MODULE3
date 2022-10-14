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
<title>Thông tin sữa</title>
<style type="text/css">
table {
	width: 1000px;
	border: 1px solid black;
	align-items: center;
	margin: auto;
	padding: 0;
	border-collapse: collapse;
}
	.style35{
	font-size: 24px;
	font-weight: bold;
	font-family: lithograph;
	color: red;
	text-align: center;
	background-color: #FFEEE6;
		
	}
	.style44{
		font-weight: bold; color: #AA1F00;
		
	}
	.style49{
		font-family: Verdana, Arial,helvetica, sans-serif;
		font-size: 12px;
	}
	img{
		width: 120px;
		height: 120px;
		vertical-align: middle;
	}
	tr,td{
	border: 1px solid gray;
	}
	
	
	
	
</style>
<%
	String sql = "SELECT * FROM SUA ORDER BY MA_HANG_SUA ASC ";
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
			int stt = 0;
	%>
	<table class=".style49">
		<tr>
			<td colspan="5" class="style35">THÔNG TIN CÁC SẢN PHẨM</td>
		</tr>
		<%while(rs.next()){ %>
			<%if(stt%5==0){ %>
			<tr>
			<%
			} %>
				<td style="padding: 10px; text-align: center;">
					<b><%=rs.getString("ten_sua") %></b><br/><br/>
					<%=rs.getInt("trong_luong")%> gr - <%=rs.getInt("don_gia")%>  VNĐ <br><br>
					<img align="center" src="images/sanpham/<%=rs.getString("hinh")%>">
				</td>
			<%
			stt = stt+1;
			%>
			<%if(stt%5==0){ %>
		</tr>
			<%} %>
		<%} %>
	</table>
	<%} %>
</body>
</html>