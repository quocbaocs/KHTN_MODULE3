<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Danh mục sản phẩm</title>
<link rel="stylesheet" href="css/style.css">
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
<%

kn = CSDL.getKetNoi();
String strQ="";
stm = kn.createStatement();

if(request.getParameter("maloai")!=null){
	
	strQ = sql+" AND SUA.MA_LOAI_SUA ='"+request.getParameter("maloai")+"'";
	
}
if(request.getParameter("mahang")!=null){
	System.out.println("dang o day 2");
	strQ =sql+" AND SUA.MA_HANG_SUA ='"+request.getParameter("mahang")+"'";
}
%>
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
				<h3>DANH MỤC SẢN PHẨM</h3>
	
	<%
	
	rs.last();
	int tsd = rs.getRow();
	tongSoTrang = tsd/soDongTrang + (tsd%soDongTrang!=1?1:0);;
	
	if(request.getParameter("page")!=null)
		trang = Integer.parseInt(request.getParameter("page"));
	int vt = (trang-1) * soDongTrang;
	rs = stm.executeQuery(strQ + " limit " + vt + "," + soDongTrang);
	int stt= vt + 1;
	 rs.beforeFirst();
%>
<% if(rs!=null){
%>
	<table class="style49">
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