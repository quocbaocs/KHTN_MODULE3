<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2 align='center'>THÔNG TIN KHÁCH HÀNG</h2>
<h3 align="center" style="color: red;"><i>${message}</i></h3>
	<table class="tblkh" style="width: 100%;"border="1">
		<tr align='center'>
			<td>Mã KH</td>
			<td>Tên khách hàng</td>
			<td>Giới tính</td>
			<td>Địa chỉ</td>
			<td>Số điện thoại</td>
			<td><img alt="" src="images/but_sua.png"></td>
			<td><img alt="" src="images/but_xoa.png"></td>
		</tr>
		<c:forEach items="${dskh}" var="kh">
		<tr>
			<td>
				${kh.maKhachHang}
			</td>
			<td>
				${kh.tenKhachHang }
			</td>
			<td align="center"><img src="images/nav/${kh.phai==true?"be_gai_2.jpg":"be_trai_1.jpg" }" width="30px" height="30px"></td>
			<td>
				${kh.diaChi}
			</td>
			<td>
				${kh.dienThoai}
			</td>
			<td>
				<a href="trang-update-ttkh.jsp?makh=${kh.maKhachHang}">Sửa</a>
			</td>
			<td>
				<a href="xoa-khach-hang?makh=${kh.maKhachHang}">Xóa</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<p align="center">
	<a href="?trang=1">&lt;&lt;</a>
	<a href="?trang=${param.trang-1<1?param.trang:param.trang-1}">&lt;</a>
	<c:forEach  begin="1" end="${tongSoTrang}" var="i">
	<a href="?trang=${i}" style="color: ${param.trang==i?"red":"black"}">${i}</a>
	</c:forEach>
	<a href="?trang=${param.trang+1>tongSoTrang?tongSoTrang:param.trang+1 }">&gt;</a>
	<a href="?trang=${tongSoTrang}">&gt;&gt;</a>