<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sữa</title>
</head>
<body>
	<table border="1" style="margin: auto; border-collapse: collapse;">
	<caption style="font-size:20px; color:red; font-weight:bold; background-color:khaki;">DANH SÁCH SỮA</caption>
		<tr>
			<th>Tên sữa</th>
			<th>Hãng sữa</th>
			<th>Loại sữa</th>
			<th>Trọng lượng</th>
			<th>Đơn giá</th>


		</tr>
		<c:forEach items="${dsSua}" var="s">
			<tr>
				<td>${s.tenSua}</td>
				<td>${s.hangSua.tenHangSua }</td>
				<td>${s.loaiSua.tenLoai }</td>
				<td>${s.trongLuong }</td>
				<td>${s.donGia}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>