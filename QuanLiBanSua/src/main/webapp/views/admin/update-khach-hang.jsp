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
			
		<form action="" method="post">
			<table class="tblcapnhatKH" style="background-color: lightyellow">
				<tr bgcolor="Gold">
					<td colspan="2" align="center"><h3 style="color: red;">CẬP
							NHẬT THÔNG TIN KHÁCH HÀNG</h3></td>
				</tr>
				<tr>
					<td>Mã khách hàng:</td>
					<td><input type="text" readonly="true" name="makh" value="${kh.maKhachHang}" style="background-color: lightgray;"></td>
				</tr>
				<tr>
					<td>Tên khách hàng:</td>
					<td><input type="text" name="tenkh" value="${kh.tenKhachHang }"></td>
				</tr>
				<tr>
					<td>Phái</td>
					<td><input type="radio" name="phai" ${kh.phai==false?"checked":""} value="0">Nam
					<input type="radio" name="phai" ${kh.phai==true?"checked":""} value="1">Nữ</td>
				</tr>
				<tr>
					<td>Địa chỉ:</td>
					<td><input type="text" name="diachi" value="${kh.diaChi}"  size="30"></td>
				</tr>
				<tr>
					<td>Điện thoại:</td>
					<td><input type="text" name="dienthoai" value="${kh.dienThoai}" size="20"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" value="${kh.email}"></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="Cập nhật"></td>
				</tr>

			</table>
			<br>
			<p>${message}</p>
		</form>
        </div>
	</jsp:attribute>
</me:template-admin>