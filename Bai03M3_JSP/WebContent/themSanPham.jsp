<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
background-color: #FF9999;
}
tr{
	margin-top: 10px;
}
</style>
</head>

<body>
	<div align="center" class="container">
		<form action="/action_page.php">
			<table>
			<tr>
			<td align="center" colspan="2" style="background-color: red; color: white;">
			<h1>THÊM MỚI SỮA</h1>
			</td>
			</tr>
				<tr>
					<td>Mã sữa: </td>
					<td><input type="text" name="maSua"/></td>
				</tr>
				<tr>
					<td>Tên sữa: </td>
					<td><input type="text" name="maSua" size="30"/></td>
				</tr>
				<tr>
					<td>Hãng sữa: </td>
					<td>
					
					</td>
				</tr>
				<tr>
					<td>Loại sữa: </td>
					<td>
					<select name="loaiSua">
						<c:forEach items="${listLoai}" var="loai">
						<option value="${loai.tenLoaiSua}">${loai.tenLoaiSua }</option>
					</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>Trọng lượng: </td>
					<td>
					<input type="text" name="maSua"/> (gr hoặc ml)
					</td>
				</tr>
				<tr>
					<td>Đơn giá: </td>
					<td>
					<input type="text" name="maSua"/> (VNĐ)
					</td>
				</tr>
				<tr>
					<td>Thành phần dinh dưỡng</td>
					<td>
					<textarea rows="2" cols="30"></textarea>
					</td>
				</tr>
				<tr>
					<td>Lợi ích:</td>
					<td>
					<textarea rows="2" cols="30"></textarea>
					</td>
				</tr>
				<tr>
					<td>Hình ảnh</td>
					<td>
					<input type="text" name="maSua"/><input type="file"> 
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="Thêm mới"> 
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>