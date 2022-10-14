<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="businessLogics.CSDL"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>Cập nhật thông tin khách hàng</title>
<style type="text/css">
table {
width:800px;
	 margin: auto;
}

.style35 {
	width: 100%; margin : auto;
	padding: 0;
	background-color: lightyellow;
	margin: auto;
}

.content {
	background-color: white;
}
</style>
<%!
	
	Connection kn = CSDL.getKetNoi();
	Statement stm ;
	ResultSet rs ;
	PreparedStatement prstmt;
	String message =null;
%>
<%request.setCharacterEncoding("UTF-8"); 
request.setCharacterEncoding("UTF-8");
%>

<%
	
	
	String tenkh = request.getParameter("tenkh");
	if(tenkh!=null){
		String makh = request.getParameter("makh");
	
	boolean phai = Boolean.parseBoolean(request.getParameter("phai"));
	String diachi = request.getParameter("diachi");
	String dienthoai = request.getParameter("dienthoai");
	String email = request.getParameter("email");
	String update = "UPDATE KHACH_HANG SET TEN_KHACH_HANG=?, PHAI=?, DIA_CHI=?, DIEN_THOAI=?, EMAIL=? WHERE MA_KHACH_HANG=?";
	try{
		prstmt = kn.prepareStatement(update);
		prstmt.setString(1,tenkh);
		prstmt.setBoolean(2,phai);
		prstmt.setString(3,diachi);
		prstmt.setString(4,dienthoai);
		prstmt.setString(5,email);
		prstmt.setString(6,makh);
		prstmt.executeUpdate();
		message = "Cập nhật khách hàng thành công";
		
		
		
		
		
	}catch(Exception e){
		e.printStackTrace();
		message = "Cần phải nhập thông tin hợp lệ";
		
		
	}
	}
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
				<!-- content -->
				<%
String sql = "SELECT * FROM KHACH_HANG WHERE MA_KHACH_HANG='"+request.getParameter("makh")+"'";
	stm = kn.createStatement();
	rs = stm.executeQuery(sql);
		//XUAT THONG TIN KHI DA CO DU LIEU
		if(rs.next()){
%>
<form action="cap_nhat_khach_hang.jsp" method="POST">
	<table class="style35">
	<tr bgcolor="Gold">
	<td colspan="2"><h3 style="color: red;">CẬP NHẬT THÔNG TIN KHÁCH HÀNG</h3></td>
	</tr>
		<tr>
			<td>Mã khách hàng:</td>
			<td><input type="text" value="<%=rs.getString("ma_khach_hang")%>" readonly="true" name="makh"></td>
		</tr>
		<tr>
			<td>Tên khách hàng:</td>
			<td><input type="text" value="<%=rs.getString("ten_khach_hang")%>" name="tenkh"></td>
		</tr>
		<tr>
			<td>Phái</td>
			<td><input type="radio" name="phai" <%=rs.getBoolean("phai")==true?"":"checked"%>  value="<%=rs.getBoolean("phai")%>">Nam<input type="radio" name="phai" <%=rs.getBoolean("phai")!=true?"":"checked"%> value="<%=rs.getBoolean("phai")%>">Nữ</td>
		</tr>
		<tr>
			<td>Địa chỉ:</td>
			<td><input type="text" value="<%=rs.getString("dia_chi")%>" name="diachi"></td>
		</tr>
		<tr>
			<td>Điện thoại:</td>
			<td><input type="text" value="<%=rs.getString("dien_thoai")%>" name="dienthoai"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" value="<%=rs.getString("email")%>" name="email"></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="Cập nhật"></td>
		</tr>
		
	</table>
	</form>
	<%}%>
				
				
				<!-- end content-->
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

	<p align="center"><b><%=message %></b></p>
	<p align="center"><a href="bai_11_capnhat_xoa_thongtin_khachhang.jsp">Quay về trang thông tin khách hàng</a></p>
	
</body>
</html>