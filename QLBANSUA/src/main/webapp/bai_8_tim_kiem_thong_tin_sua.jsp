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
table {
	width: 600px;
	margin: auto;
	border: 1px solid black;
	border-collapse: collapse;
	background-color: #FFF5EE	;
}
table tr td{
border: 1px solid black;}

input[type=submit] {
	border: 1px solid gray;
}
</style>

<%
String sql = "SELECT * FROM SUA, LOAI_SUA, HANG_SUA " + "WHERE SUA.MA_LOAI_SUA = LOAI_SUA.MA_LOAI_SUA "
		+ "AND SUA.MA_HANG_SUA = HANG_SUA.MA_HANG_SUA ";

Connection kn = CSDL.getKetNoi();
Statement stm;
ResultSet rs;
Locale lc = new Locale("vi", "VN");
NumberFormat nf = NumberFormat.getInstance();

int tsd = 0;
%>
</head>
<body>


	<%!Connection kn = CSDL.getKetNoi();
	Statement stm;
	ResultSet rs;
	PreparedStatement prstmt;
	String message = null;%>
	<%
	request.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
	%>
	<%
	stm = kn.createStatement();
	%>
	<form action="" method="get">
		<table class="styleh">
			<tr>
				<td width="525"><h1 style="color: red; text-align: center;">TÌM KIẾM THÔNG TIN SỮA</h1></td>
			</tr>
			<tr align="center" style="padding-bottom: 15px; background-color: #D3D3D3;">
				<td><b>Tên sữa: </b><input type="text" name="keyword" size="30" />&nbsp;
					<input type="submit" value="Tìm kiếm"
					style="background-color: rgb(223, 124, 124);" /></td>
			</tr>

		</table>
	</form>
	<%
	if (request.getParameter("keyword") != null) {
		String keyword = request.getParameter("keyword");
		String loai = request.getParameter("loai");
		String hang = request.getParameter("hang");

		//stm = kn.createStatement();
		sql += " AND SUA.TEN_SUA LIKE '%" + request.getParameter("keyword") + "%' ";
		;
		rs = stm.executeQuery(sql);
		rs.last();
		tsd = rs.getRow();
		rs.beforeFirst();
	%>
	<%
	if (tsd > 0 && request.getParameter("keyword").trim().length() > 0) {
	%>
	<p align="center">
		<b>Có <%=tsd%> sản phẩm được tìm thấy
		</b>
	</p>
	<table >
		<%
		while (rs.next()) {
		%>
		<tr>
			<td colspan="2"><h3 align="center" style="color: red;"><%=rs.getString("ten_sua")%> -
				<%=rs.getString("ten_hang_sua")%></h3></td>
		</tr>
		<tr class="style37" style="border-top: 5px; margin: 0">
			<td style="padding: 0;"><img alt="hinh"
				src="images/sanpham/<%=rs.getString("hinh")%>" width="80px"
				height="80px"></td>
			<td style="padding: 0"><br> <b><i>Thành phần dinh
						dưỡng:</i></b><br> <%=rs.getString("tp_dinh_duong")%><br /> <b><i>Lợi
						ích:</i></b><br> <%=rs.getString("loi_ich")%>
				<p>
					<b><i>Trọng lượng:</i></b> <span><%=rs.getInt("trong_luong")%></span>
					gr - <b><i>Đơn giá:</i></b> <span><%=nf.format(rs.getInt("don_gia"))%>
						VNĐ</span>
				</p></td>
		</tr>

		<%
		}
		%>
		<%
		} else {
		%>
		<p align="center" style="padding-bottom: 15px;">
			<b>Không tìm thấy sản phẩm này</b>
		</p>
		<%
		}
		%>
	</table>
	<%
	}
	%>


	<!-- END CONTENT -->



</body>
</html>