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
				<td colspan="5" style="background-color: peachpuff"><h1
						style="color: red; text-align: center;">THÔNG TIN CÁC SẢN PHẨM</h1></td>
			</tr>
			<c:forEach items="${listSanPham}" var="sp" varStatus="count">
			<c:if test="${count.index %5==0}">
				<tr>
				</c:if>
				<c:if test="${count.index %5!=0}">
				<td align="center">
				<a href="ChiTietSanPhamServlet?id=${sp.maSua}"><b>${sp.tenSua}</b></a>
						<p>${sp.loaiSua.tenLoaiSua}- ${sp.trongLuong} gr - ${sp.donGia }
							VNĐ</p>
					<img src="images/sanpham/${sp.hinh}">
					</td>
					</c:if>
					<c:if test="${count.index%5==0}">
				</tr>
				</c:if>

			</c:forEach>
		</table>

	</div>

</body>
</html>