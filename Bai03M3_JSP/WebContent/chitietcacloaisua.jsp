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
table{
width: 600px;
height: 300px;
}

table, tr, td, th {
	border: 1px solid;
	border-collapse: collapse;
	
}
img {
	width: 120px;
	height: 120px;
}
span{
color: red;
}

</style>

</head>
<body>
	<div align="center">
	<h1>THÔNG TIN CHI TIẾT CÁC lOẠI SỮA</h1>
	<BR>
		<table>
		<c:forEach items="${listSanPham}" var="spSua">
		<tr>
		<td colspan="2" style="background-color: #FFA500;"><h1 style="center; color: red; text-align: center;">${spSua.tenSua }</h1><br></td>
		</tr>
		<tr>
		
			<td><img src="images/sanpham/${spSua.hinh}"></td>
			<td style="padding-left: 5px; margin: 0">
			<b>Thành phần dinh dưỡng</b>
			<p>${spSua.tpDinhDuong }</p>
			<br>
			<b>Lợi ích:</b>
			<p>${spSua.loiIch })</p>
			<br>
			<b>Trọng lượng: </b><span>${spSua.trongLuong}</span> - <b>Đơn giá: </b><span>${spSua.donGia } VNĐ</span>
			</td>
			
		</tr>
		</c:forEach>
		</table>
		<a href="#">&laquo;</a>
		 <a href="#"><</a>
	  <a href="#">1</a>
	  <a class="active" href="#">2</a>
	  <a href="#">3</a>
	  <a href="#">4</a>
	  <a href="#">5</a>
	  <a href="#">></a>
	  <a href="#">&raquo;</a>
	</div>
	<script type="text/javascript">
	function goForward() {
		history.go(-1);
		}
	</script>

</body>
</html>