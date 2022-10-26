<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<form action="" method="post">
	<table class="tbltimkiem"
		style="border-collapse: collapse; width: 100%">
		<tr align="center">
			<td>
				<h1 style="color: red;">TÌM KIẾM THÔNG TIN SỮA</h1>
			</td>
		</tr>
		<tr align="center">
			<td><b>Loại sữa:</b> <select name="cboLoai">
					<c:forEach items="${dsls}" var="ls">
						<option value="${ls.maLoai }">${ls.tenLoai}</option>
					</c:forEach>
			</select> <b>Hãng sữa:</b> <select name="cboHang">
					<c:forEach items="${dshs}" var="hs">
						<option value="${hs.maHang}">${hs.tenHang}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr align="center" style="padding-bottom: 15px;">
			<td><b>Tên sữa: </b><input type="text" name="keyword" size="50" />&nbsp;
				<input type="submit" value="Tìm kiếm"
				style="background-color: rgb(223, 124, 124);"></td>
		</tr>
	</table>
</form>
<!-- -->
<c:if test="${soSP != null}">
	<h3 align="center">${soSP} sản phẩm được tìm thấy</h3>
</c:if>
<table class="tblttsp" style="width: 100%;">
	<c:forEach items="${dsSua}" var="sp">

		<tr align="center">
			<td colspan="2" bgcolor="#FFEEE6">
				<h2 style="color: red;">${sp.tenSua}</h2>
			</td>
		</tr>
		<tr>
			<td align="center"><img src="images/sanpham/${sp.hinh}"
				width="140px" height="180px"></td>
			<td><b>Thành phần dinh dưỡng:</b><br /> Sữa không béo, dầu
				${sp.tpDinhDuong}<br> <b>Lợi ích:</b><br /> ${sp.loiIch} <br>
				<p>
					<b><i>Trọng lượng:</i></b> 400 gr - <b><i>Đơn giá: </i></b>
					70,000VNĐ
				</p></td>
		</tr>
	</c:forEach>
</table>