<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

table, tr, td {
	border: 1px solid;
	border-collapse: collapse;
}

img {
	width: 90px;
	height: 90px;
}
</style>

</head>
<body>
	<div align="center">
		<table>
			<tr>
				<td colspan="2" style="background-color: peachpuff"><h1 style="color: red;">THÔNG TIN CÁC SẢN
						PHẨM</h1></td>
			</tr>
			<c:forEach items="${listSanPham}" var="sp">
				<tr>
					<td><img src="images/sanpham/${sp.hinh}"></td>
					<td>
						<b>${sp.tenSua}</b><br/><br>
						<p>Nhà sản xuất: ${sp.hangSua.tenHangSua}</p>
						<p>${sp.loaiSua.tenLoaiSua} - ${sp.trongLuong} gr - ${sp.donGia } VNĐ</p>
					
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>