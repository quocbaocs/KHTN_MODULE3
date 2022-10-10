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
tr:nth-child(odd) {background: #FFA500	}
img {
	width: 120px;
	height: 120px;
}
</style>

</head>
<body>
	<div align="center">

		
		<table>
		<tr>
		<td colspan="2"><h1 style="center; color: red; text-align: center;">${spSua.tenSua }</h1><br></td>
		</tr>
		<tr>
			<td><img src="images/sanpham/${spSua.hinh}"></td>
			<td style="padding-left: 5px; margin: 0">
			<b>Thành phần dinh dưỡng</b>
			<p>${spSua.tpDinhDuong }</p>
			<br>
			<b>Lợi ích:</b>
			<p>${spSua.loiIch })</p>
			</td>
		</tr>
		<tr style="background-color: #ffff;">
		<td align="right"><a onclick="goForward()" style="text-decoration:underline;">Quay về</a></td>
		<td align="right">
			<b>Trọng lượng: </b>${spSua.trongLuong} - <b>Đơn giá: </b>${spSua.donGia } VNĐ
		</td>
		</tr>
		</table>

	</div>
	<script type="text/javascript">
	function goForward() {
		history.go(-1);
		}
	</script>

</body>
</html>