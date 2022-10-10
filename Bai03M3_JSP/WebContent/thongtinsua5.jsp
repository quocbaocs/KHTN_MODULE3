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

table, tr, td, th {
	border: 1px solid;
	border-collapse: collapse;
}
tr:nth-child(odd) {background: #FFA500	}
img {
	width: 90px;
	height: 90px;
}
</style>

</head>
<body>
	<div align="center">

		<h1 style="center;">THÔNG TIN SỮA</h1><br>
		<table>
			<tr style="text-align: center;">
				<th>Số STT</th>
				<th>Tên sữa</th>
				<th>Hãng sữa</th>
				<th>Loại sữa</th>
				<th>Trọng lượng</th>
				<th>Đơn giá</th>
			</tr>
			<c:forEach items="${listSanPham}" var="sp" varStatus="count">
				<tr>
					<td>${count.index+1}</td>
					<td>${sp.tenSua}</td>
					<td>${sp.hangSua.tenHangSua}</td>
					<td>${sp.loaiSua.tenLoaiSua}</td>
					<td>${sp.trongLuong} gram</td>
					<td>${sp.donGia} VNĐ</td>
					
				</tr>
			</c:forEach>
		</table>
		<a href="#">&laquo;</a>
	  <a href="#">1</a>
	  <a class="active" href="#">2</a>
	  <a href="#">3</a>
	  <a href="#">4</a>
	  <a href="#">5</a>
	  <a href="#">6</a>
	  <a href="#">&raquo;</a>

	</div>

</body>
</html>