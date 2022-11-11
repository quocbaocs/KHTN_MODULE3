<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="me"%>
<me:template-admin title="Quan li khach hang">
	<jsp:attribute name="content">
		<div class="main-content-1" align="center">
		<c:if test="${message!=null}">
			<p style="color: blue;">${message}</p>
		</c:if>
			
		<form action="" method="post" enctype="multipart/form-data">
			<table id="tblthem">
				<tr bgcolor="red">
					<td colspan="2" align="center"><h1 style="color: white;">THÊM SỮA MỚI</h1></td>
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
					<td>
						<select name="cboHangSua">
							<c:forEach items="${dshs}" var="hs">
								<option value="${hs.maHangSua}">${hs.tenHangSua}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>Loại sữa:</td>
					<td>
						<select name="cboLoaiSua">
							<c:forEach items="${dsls}" var="ls">
								<option value="${ls.maLoaiSua}">${ls.tenLoai}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>Trọng lượng:</td>
					<td><input name="trongLuong" type="text" size="15"> (gr hoặc ml)</td>
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
					<td>
						<input type="file" id="file" name="file">
					</td>
				</tr>
				<tr>
		
					<td colspan="2" align="center"><input type="submit"
							value="Thêm mới"></td>
				</tr>
			</table>
		</form>
        </div>
	</jsp:attribute>
</me:template-admin>