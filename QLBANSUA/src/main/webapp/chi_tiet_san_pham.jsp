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
<style type="text/css">
table{
margin:auto;
border-collapse: collapse;
width: 600px;
background-color: #E6E6FA	;
}
table tr td {
	border: 2px solid brown;
}
</style>

<%
String sql = "SELECT * FROM SUA, LOAI_SUA, HANG_SUA WHERE SUA.MA_LOAI_SUA = LOAI_SUA.MA_LOAI_SUA "
		+ "AND SUA.MA_HANG_SUA = HANG_SUA.MA_HANG_SUA AND SUA.MA_SUA=?";
Connection kn = CSDL.getKetNoi();
PreparedStatement prstmt;
ResultSet rs;
%>
</head>
<body>

	<table>
		<!-- content -->
		<%
		String ma_sua = request.getParameter("masua");
		prstmt = kn.prepareStatement(sql);
		prstmt.setString(1, ma_sua);
		rs = prstmt.executeQuery();

		Locale lc = new Locale("vi", "VN");
		NumberFormat nf = NumberFormat.getInstance();
		%>
		<%
		if (rs != null) {
		%>
		<table class="style49">
			<%
			while (rs.next()) {
			%>
			<tr bgcolor="#FFDAB9	">
				<td align="center" colspan="2"><h2 style="color: red"><%=rs.getString("ten_sua")%> -
					<%=rs.getString("ten_hang_sua")%></h2></td>
			</tr>
			<tr class="style37">
				<td><img alt="hinh"
					src="images/sanpham/<%=rs.getString("hinh")%>"></td>
				<td style="padding-left: 15px;"><br> <b><i>Thành phần dinh dưỡng:</i></b><br> <%=rs.getString("tp_dinh_duong")%><br />
					<b><i>Lợi ích:</i></b><br> <%=rs.getString("loi_ich")%>
					<p align="right">
						<b><i>Trọng lượng:</i></b>
						<%=rs.getInt("trong_luong")%>
						gr - <b><i>Đơn giá:</i></b>
						<%=nf.format(rs.getInt("don_gia"))%>
						VNĐ
					</p></td>
			</tr>
			<tr class="style37">
				<td align="right" colspan="1"><a href="#" onclick="quayve()">Quay
						về</a></td>
			</tr>

			<%
			}
			%>
		</table>


		<%
		}
		%>

		<script type="text/javascript">
			function quayve() {
				history.go(-1);
			}
		</script>





	</table>





</body>
</html>