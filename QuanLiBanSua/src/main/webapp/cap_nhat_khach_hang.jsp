
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="m"%>
<m:layout_ct title="Xin chào">
	
	<jsp:attribute name="content">
	
		<form action="cap_nhat_khach_hang.jsp" method="POST">
			<table class="tblcapnhat"
				style="width: 40%; border-collapse: collapse;">
				<tr bgcolor="Gold">
					<td colspan="2" align="center"><h3 style="color: red;">CẬP
							NHẬT THÔNG TIN KHÁCH HÀNG</h3></td>
				</tr>
				<tr>
					<td>Mã khách hàng:</td>
					<td><input type="text" readonly="true" name="makh"></td>
				</tr>
				<tr>
					<td>Tên khách hàng:</td>
					<td><input type="text" name="tenkh"></td>
				</tr>
				<tr>
					<td>Phái</td>
					<td><input type="radio" name="phai">Nam<input
						type="radio" name="phai">Nữ</td>
				</tr>
				<tr>
					<td>Địa chỉ:</td>
					<td><input type="text" name="diachi"></td>
				</tr>
				<tr>
					<td>Điện thoại:</td>
					<td><input type="text" name="dienthoai"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="Cập nhật"></td>
				</tr>

			</table>
		</form>
	</jsp:attribute>

</m:layout_ct>