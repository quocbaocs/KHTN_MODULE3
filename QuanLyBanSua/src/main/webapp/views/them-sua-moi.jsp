<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="ThemSuaServlet" method="post"
	enctype="multipart/form-data">
	<table class="tblthem"
		style="border-collapse: collapse; width: 100%; background-color: lightyellow">
		<tr bgcolor="red">
			<td colspan="2" align="center"><h5 style="color: white;">THÊM
					SỮA MỚI</h5></td>
		</tr>
		<c:if test="${message!=null}">
			<tr align="center">
				<td colspan="2"><b><h5 align="center">${message}</h5></b></td>
			</tr>
		</c:if>
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
			<td><select name="cboHang">
					<c:forEach items="${dshs}" var="hs">
						<option value="${hs.maHang}">${hs.tenHang}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Loại sữa:</td>
			<td><select name="cboLoai">
					<c:forEach items="${dsls}" var="ls">
						<option value="${ls.maLoai }">${ls.tenLoai}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Trọng lượng:</td>
			<td><input name="trongLuong" type="text" size="15"> (gr
				hoặc ml)</td>
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
