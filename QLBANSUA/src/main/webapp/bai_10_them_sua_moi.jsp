<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
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
<title>Thêm sữa mới</title>
<style type="text/css">
	table {
	margin: auto;
	background-color: lightyellow;
}
</style>
<link rel="stylesheet" href="css/style.css">
<%!String qrLoai = "SELECT * FROM LOAI_SUA";
	String qrHang = "SELECT * FROM HANG_SUA";
	String qrThem = "INSERT INTO SUA VALUES (?,?,?,?,?,?,?,?,?)";
	Connection kn = CSDL.getKetNoi();
	Statement stm;
	PreparedStatement prstmt;
	ResultSet rs;
	int result;%>
<%
stm = kn.createStatement();
%>
</head>
<body>

	<table>
		<!-- content -->
		<form action="" method="get">
			<table class="style98">
				<tr bgcolor="red">
					<td colspan="2" align="center" class="tieude">THÊM SỮA MỚI</td>
				</tr>
				<tr>
					<td>Mã sữa:</td>
					<td><input name="maSua" type="text" size="15"></td>
				</tr>
				<tr>
					<td>Tên sữa:</td>
					<td><input name="tenSua" type="text" size="30"></td>
				</tr>
				<tr>
					<td>Hãng sữa:</td>
					<td><select name="hang">
							<%
							rs = stm.executeQuery(qrHang);
							while (rs.next()) {
							%>
							<option value="<%=rs.getString("ma_hang_sua")%>"><%=rs.getString("ten_hang_sua")%></option>
							<%
							}
							%>
					</select></td>
				</tr>
				<tr>
					<td>Loại sữa:</td>
					<td><select name="loai">
							<%
							rs = stm.executeQuery(qrLoai);
							while (rs.next()) {
							%>
							<option value="<%=rs.getString("ma_loai_sua")%>"><%=rs.getString("ten_loai")%></option>
							<%
							}
							%>
					</select></td>
				</tr>
				<tr>
					<td>Trọng lượng:</td>
					<td><input name="trongluong" type="text" size="15">
						(gr hoặc ml)</td>
				</tr>
				<tr>
					<td>Đơn giá:</td>
					<td><input name="donGia" type="text" size="15"> (VNĐ)</td>
				</tr>
				<tr>
					<td>Thành phần dinh dưỡng:</td>
					<td><textarea name="tpdd" cols="40" rows="5"> </textarea></td>
				</tr>
				<tr>
					<td>Lợi ích:</td>
					<td><textarea name="loiIch" cols="40" rows="5"></textarea></td>
				</tr>
				<tr>
					<td>Hình ảnh:</td>
					<td><input name="hinh" type="text" size="30" id="hinh">
						<input type="file" id="file" name="file"></td>
				</tr>
				<tr>

					<td colspan="2" align="center"><input type="submit"
						value="Thêm mới"></td>
				</tr>
			</table>

		</form>
		<%
		if (request.getParameter("maSua") != null && request.getParameter("tenSua") != null) {
			try {
				String maSua = request.getParameter("maSua");
				String tenSua = request.getParameter("tenSua");
				String hang = request.getParameter("hang");
				String loai = request.getParameter("loai");
				int donGia = Integer.parseInt(request.getParameter("donGia"));
				int trongLuong = Integer.parseInt(request.getParameter("trongluong"));
				String tpdd = request.getParameter("tpdd");
				String loiIch = request.getParameter("loiIch");
				String hinh = request.getParameter("hinh");

				prstmt = kn.prepareStatement(qrThem);
				prstmt.setString(1, maSua);
				prstmt.setString(2, tenSua);
				prstmt.setString(3, hang);
				prstmt.setString(4, loai);
				prstmt.setInt(5, trongLuong);
				prstmt.setInt(6, donGia);
				prstmt.setString(7, tpdd);
				prstmt.setString(8, loiIch);
				prstmt.setString(9, hinh);

				result = prstmt.executeUpdate();
				if (result > 0) {
		%>
		<p align="center">
			<b>Thêm sản phẩm thành công</b>
		</p>
		<br>

		<%
		String sql = "SELECT * FROM SUA, LOAI_SUA, HANG_SUA WHERE SUA.MA_LOAI_SUA = LOAI_SUA.MA_LOAI_SUA "
				+ "AND SUA.MA_HANG_SUA = HANG_SUA.MA_HANG_SUA AND SUA.MA_SUA=?";
		String ma_sua = request.getParameter("maSua");
		prstmt = kn.prepareStatement(sql);
		prstmt.setString(1, ma_sua);
		rs = prstmt.executeQuery();

		Locale lc = new Locale("vi", "VN");
		NumberFormat nf = NumberFormat.getInstance();

		if (rs != null) {
		%>
		<table class="style49">
			<%
			while (rs.next()) {
			%>
			<tr>
				<td class="style35" colspan="2"><%=rs.getString("ten_sua")%> -
					<%=rs.getString("ten_hang_sua")%></td>
			</tr>
			<tr class="style37">
				<td><img alt="hinh"
					src="images/sanpham/<%=rs.getString("hinh")%>"></td>
				<td><br> <b><i>Thành phần dinh dưỡng:</i></b><br> <%=rs.getString("tp_dinh_duong")%><br />
					<b><i>Lợi ích:</i></b><br> <%=rs.getString("loi_ich")%><br>
					<p">
						<b><i>Trọng lượng:</i></b> <span><%=rs.getInt("trong_luong")%></span>
						gr - <b><i>Đơn giá:</i></b> <span><%=nf.format(rs.getInt("don_gia"))%>
							VNĐ</span></span>
					</p></td>
			</tr>


			<%
			}
			%>
		</table>


		<%
		}
		%>

		<%
		}
		} catch (Exception e) {
		e.printStackTrace();
		%>
		<p align="center">
			<b>Không thể thêm hãy kiểm tra lại thông tin</b>
		</p>

		<%
		}
		%>

		<%
		} else {
		%>
		<p align="center">
			<b>thêm thành công</b>
		</p>
		<%
		}
		%>
		<script type="text/javascript">
			function getSelectionFile() {
				var preview = document.querySelector('#hinh');
				var file = document.getElementById("file").files[0];
				preview.value = file.name;
			}
		</script>



		<!-- END CONTENT -->
	</table>




</body>
</html>