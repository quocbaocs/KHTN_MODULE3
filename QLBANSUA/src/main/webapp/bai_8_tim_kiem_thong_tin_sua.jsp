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
<link rel="stylesheet" href="css/style.css">


<%!
String sql = "SELECT * FROM SUA, LOAI_SUA, HANG_SUA "
		+"WHERE SUA.MA_LOAI_SUA = LOAI_SUA.MA_LOAI_SUA "
		+"AND SUA.MA_HANG_SUA = HANG_SUA.MA_HANG_SUA";
		Connection kn = CSDL.getKetNoi();
		Statement stm;
		ResultSet rs;
		Locale lc = new Locale("vi", "VN");
		NumberFormat nf = NumberFormat.getInstance();
		
		
	int tsd = 0;
%>
</head>
<body>
 <form action="" method="get">
<table class="styleh">
  <tr>
    <td width="525"><h1>TÌM KIẾM THÔNG TIN SỮA</h1></td>
  </tr>
  <tr align="center" style="padding-bottom: 15px;">
 
    <td><b>Tên sữa: </b><input type="text" name="keyword" size="50"/>&nbsp;
    <input type="submit" value="Tìm kiếm" style="background-color:   rgb(223,124,124);"></td>
    
  </tr>
</table>
</form>
<% if(request.getParameter("keyword")!=null){
	sql =sql+" AND SUA.TEN_SUA LIKE '%"+request.getParameter("keyword")+"%'";
	stm = kn.createStatement();
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
				<p><b><i>Trọng lượng:</i></b> <span><%=rs.getInt("trong_luong")%></span>  gr - <b><i>Đơn giá:</i></b> <span><%=nf.format(rs.getInt("don_gia")) %> VNĐ</span></p>
			</td>
		</tr>
	
	<%} %>
	<%}else{%>
	
	<p align="center"><b>Không tìm thấy sản phẩm này</b></p>
<%} %>
</table>
<%}%>

</body>
</html>