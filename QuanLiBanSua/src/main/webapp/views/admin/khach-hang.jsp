<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="me"%>
<me:template-admin title="Quan li khach hang">
	<jsp:attribute name="content">
		<div class="main-content-1" align="center">
		<h2>Thông tin khách hàng</h2>
               <p>
				<a href="#">Thêm mới khách hàng</a>
			</p>
			<br>
			<p style="color: red;">
			${message}
			</p>
			<br>
               <table border="1"
				style="border-collapse: collapse; width: 100%;">
               
              		<tr>
              			<th>Mã KH</th>
              			<th>Tên khách hàng</th>
              			<th>Giới tính</th>
              			<th>Địa chỉ</th>
              			<th>Số điện thoại</th>
              			<th>Email</th>
              			<th><img
						src="${pageContext.request.contextPath }/images/icons/but_sua.png"></th>
              			<th><img
						src="${pageContext.request.contextPath }/images/icons/but_xoa.png"></th>
              		</tr>
              		<c:forEach var="kh" items="${dskh}">
	              		<tr>
	              			<td>${kh.maKhachHang}</td>
	              			<td>${kh.tenKhachHang}</td>
	              			<td>${kh.phai eq true?'Nữ':'Nam'}</td>
	              			<td>${kh.diaChi}</td>
	              			<td>${kh.dienThoai}</td>
	              			<td>${kh.email}</td>
	              			<td><a href="cap-nhat?makh=${kh.maKhachHang}">Sửa</a></td>
	              			<td><a href="xoa-khach-hang?makh=${kh.maKhachHang}">Xóa</a></td>
	              		</tr>
              		</c:forEach>
               </table>
               <br>
               <div class="pagination">
					   <a href="?trang=1">&lt;&lt;</a>
					   <a href="?trang=${param.trang-1<1?1:param.trang-1}">&lt;</a>
					  <c:forEach begin="1" end="${tongSoTrang}" var="i" step="1">
					 	 <a class="${param.trang eq i ? 'active':'' }" href="?trang=${i}">${i}</a>
					  </c:forEach>
					  
					  <a href="?trang=${param.trang+1>tongSoTrang?tongSoTrang:param.trang+1}">&gt;</a>
					  <a href="?trang=${tongSoTrang}">&gt;&gt;</a>
				</div> 
        </div>
	</jsp:attribute>
</me:template-admin>