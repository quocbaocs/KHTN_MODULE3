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
<title>Chi tiết sản phẩm sữa</title>
<link rel="stylesheet" href="css/style.css">

<%
	String sql = "SELECT * FROM SUA, LOAI_SUA, HANG_SUA WHERE SUA.MA_LOAI_SUA = LOAI_SUA.MA_LOAI_SUA "
	+"AND SUA.MA_HANG_SUA = HANG_SUA.MA_HANG_SUA AND SUA.MA_SUA=?";
	//Connection kn = CSDL.getKetNoi();
	PreparedStatement prstmt;
	//ResultSet rs;
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
	String ma_sua = request.getParameter("masua");
	prstmt = kn.prepareStatement(sql);
	prstmt.setString(1, ma_sua);
	rs = prstmt.executeQuery();
	
	
	Locale lc = new Locale("vi", "VN");
	NumberFormat nf = NumberFormat.getInstance();
	
%>
<% if(rs!=null){

%>
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
				<p align="right"><b><i>Trọng lượng:</i></b> <%=rs.getInt("trong_luong")%>  gr - <b><i>Đơn giá:</i></b> <%=nf.format(rs.getInt("don_gia")) %> VNĐ</p>
			</td>
		</tr>
		<tr class="style37">
			<td align="right" colspan="1"><a href="#" onclick="quayve()">Quay về</a></td>
		</tr>
	
	<%} %>
	</table>


<%} %>

<script type="text/javascript">
function quayve() {
	history.go(-1);
}
</script>
				
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