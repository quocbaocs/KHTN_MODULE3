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
<link rel="stylesheet" href="css/style.css">


<%
	String sql = "SELECT * FROM KHACH_HANG";
	//Connection kn = CSDL.getKetNoi();
	//Statement stm ;
	//ResultSet rs ;
	int result;
	String message=null;
	String sqlSelect = "SELECT * FROM KHACH_HANG,HOA_DON WHERE HOA_DON.MA_KHACH_HANG=KHACH_HANG.MA_KHACH_HANG AND HOA_DON.MA_KHACH_HANG= '";
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
				<!-- Content -->
				
				<%stm = kn.createStatement(); %>
	
	<p class='style3' align='center'>THÔNG TIN KHÁCH HÀNG</p>
	<%
	if(request.getParameter("message")!=null){
	%>
	<p align="center"><b><%=request.getParameter("message") %></b></p>
	<%} %>
	
		<%
			if(request.getParameter("makh")!=null){
				rs = stm.executeQuery(sqlSelect+request.getParameter("makh")+"'");
				if(rs.next()){
					%>
					<p align="center" style="color: red;"><b>Khách hàng,<%=rs.getString("ten_khach_hang") %> đã mua hàng nên không thể xóa được.</b></p>
		<% 	}
				else{
					String delete = "DELETE FROM KHACH_HANG WHERE MA_KHACH_HANG='"+request.getParameter("makh") +"'";
					 stm.executeUpdate(delete);
					%>
						<p align="center"><b>Đã xóa thông tin khách hàng</b></p>
					
					
				

		<%} %>
		<%} %>
		
		
<%
	rs = stm.executeQuery(sql);
	%>
	<%
		//XUAT THONG TIN KHI DA CO DU LIEU
		if(rs.next()){
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
		<% while(rs.next()){%>
			<tr>
				<td><%=rs.getString("ma_khach_hang") %></td>
				<td><%=rs.getString("ten_khach_hang") %></td>
				<td><%=rs.getBoolean("phai")!=true?"Nam":"Nữ"%></td>
				<td><%=rs.getString("dia_chi") %></td>
				<td><%=rs.getString("dien_thoai") %></td>
				<td><a href="cap_nhat_khach_hang.jsp?makh=<%=rs.getString("ma_khach_hang")%>">Sửa</a></td>
				<td><a href="?makh=<%=rs.getString("ma_khach_hang")%>">Xóa</a></td>
			</tr>
		<%}%>
		</table>
	
	<%} %>
				
				
				
				<!-- end content -->
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