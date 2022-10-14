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
table{
width: 800px;
margin: auto;
}
.content{

background-color: white;
}
	.styleh{
	width: 100%;
	height:auto;
	margin: auto;
	padding-bottom:15px;
	background-color: rgb(223,124,124);
	margin-bottom: 15px;
	}
	.style49{
		align-content: center;
		width: 100%;
		margin:auto;
		font-size:15px;
		padding:0;
		border: 3px solid brown;
		
	}
	tr,td,.style49{
	border: 1px solid black;}
	.style35{
		text-align: center;
		height:60px;
		background-color: #ffeee6;
		font-size: 20px;
		color: red;
		font-weight: bold;
		font-family: serif;
		
	}
	
	span{
		word-spacing: 5;
		color: red;
	}
	h3{
 		color: RGB(223,15,42);
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
	input[type=submit] {
	border: 1px solid gray;
}
</style>

<%
String sql = "SELECT * FROM SUA, LOAI_SUA, HANG_SUA "
		+"WHERE SUA.MA_LOAI_SUA = LOAI_SUA.MA_LOAI_SUA "
		+"AND SUA.MA_HANG_SUA = HANG_SUA.MA_HANG_SUA ";

		//Connection kn = CSDL.getKetNoi();
		//Statement stm;
		//ResultSet rs;
		Locale lc = new Locale("vi", "VN");
		NumberFormat nf = NumberFormat.getInstance();
		
		
	int tsd = 0;
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
				<!-- CONTENT-->
			
<%
	stm = kn.createStatement();
	
	
%>
	<form action="" method="get">
		<table class="styleh">
		  <tr>
		    <td width="525"><h3>TÌM KIẾM THÔNG TIN SỮA</h3></td>
		  </tr>
		  
		  <tr align="center" style="padding-bottom: 15px;" class="style38">
		    <td><b>Loại sữa: </b>
		    <select name="loai">
		    <%
		    //qrLoai ="SELECT * FROM LOAI_SUA";
			rs=stm.executeQuery(qrLoai);
		    while(rs.next()){ %>
		    	<option value="<%=rs.getString("ma_loai_sua") %>"><%=rs.getString("ten_loai") %></option>
		    <%} %>
		    </select>
		    &nbsp;
		    <b>Hãng sữa: </b>
		    <select name="hang">
		    <%
		   // qrHang ="SELECT * FROM HANG_SUA";
			rs=stm.executeQuery(qrHang);
		    while(rs.next()){ %>
		    	<option value="<%=rs.getString("ma_hang_sua") %>"><%=rs.getString("Ten_hang_sua") %></option>
		    <%} %>
		    </select>
		    &nbsp;
		    </td>
		  </tr>
		  
		  
		  <tr align="center" style="padding-bottom: 15px;" class="style38">
		    <td><b>Tên sữa: </b><input type="text" name="keyword" size="30"/>&nbsp;
		    <input type="submit" value="Tìm kiếm" style="background-color:   rgb(223,124,124);"/></td>
		  </tr>
		  
		</table>
	</form>
	<% if(request.getParameter("keyword")!=null){
		String keyword = request.getParameter("keyword");
		String loai = request.getParameter("loai");
		String hang = request.getParameter("hang");

	//stm = kn.createStatement();
	sql += " AND SUA.TEN_SUA LIKE '%"+request.getParameter("keyword")+"%' AND SUA.MA_HANG_SUA ='"+hang+"' AND"+" SUA.MA_LOAI_SUA='"+loai+"'";;
	rs = stm.executeQuery(sql);
	rs.last();
	tsd = rs.getRow(); 
	rs.beforeFirst();
%>
<%if(tsd>0 && request.getParameter("keyword").trim().length()>0){ %>
<p align="center"><b>Có <%=tsd %> sản phẩm được tìm thấy</b></p>
<table class="style49">
	<%
	while(rs.next()){
	%>
		<tr>
			<td class="style35" colspan="2">
				<%=rs.getString("ten_sua") %> - <%=rs.getString("ten_hang_sua") %>
			</td>
		</tr>
		<tr class="style37" style="border-top: 5px; margin: 0">
			<td style="padding: 0;">
				<img alt="hinh" src="images/sanpham/<%=rs.getString("hinh")%>" width="80px" height="80px">
			</td>
			<td style="padding: 0">
			<br>
				<b><i>Thành phần dinh dưỡng:</i></b><br>
				<%=rs.getString("tp_dinh_duong") %><br/>
				<b><i>Lợi ích:</i></b><br>
				<%=rs.getString("loi_ich") %>
				<p><b><i>Trọng lượng:</i></b> <span><%=rs.getInt("trong_luong")%></span>  gr - <b><i>Đơn giá:</i></b> <span><%=nf.format(rs.getInt("don_gia")) %> VNĐ</span></p>
			</td>
		</tr>
	
	<%} %>
	<%}else{%>
	<p align="center" style="padding-bottom: 15px;"><b>Không tìm thấy sản phẩm này</b></p>
<%} %>
</table>
<%}%>

				
				<!-- END CONTENT -->
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