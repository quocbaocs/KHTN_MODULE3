<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table style="width: 100%" class="tbldanhmuc" border="1">
	<tr align="center" bgcolor=" #ffe0c1" style="font-weight: bold;">
		<td>Hình</td>
		<td>Tên sữa</td>
		<td>Trọng lượng <br>(gr)
		</td>
		<td>Đơn giá<br>(VNĐ)
		</td>
	</tr>
	<c:forEach items="${dssp}" var="sp">
		<tr>
			<td><img src="images/sanpham/${sp.hinh}"
				style="width: 40px; height: 40px;"></td>
			<td align="left"><a
				href="bai-7-trang-chi-tiet-sua.jsp?maSua=${sp.maSua}"
				style="color: red">${sp.tenSua}</a></td>
			<td align="center">${sp.trongLuong } gr</td>
			<td><fmt:formatNumber value="${sp.donGia}" /> VNĐ</td>
		</tr>
	</c:forEach>

</table>
<c:if test="${tongSoTrang !=null}">
	<p align="center">
		<a href="?trang=1">&lt;&lt;</a> <a
			href="?trang=${param.trang-1<1?param.trang:param.trang-1}">&lt;</a>
		<c:forEach begin="1" end="${tongSoTrang}" var="i">
			<a href="?trang=${i}" style="color: ${param.trang==i?"red":"black"}">${i}</a>
		</c:forEach>
		<a
			href="?trang=${param.trang+1>tongSoTrang?tongSoTrang:param.trang+1 }">&gt;</a>
		<a href="?trang=${tongSoTrang}">&gt;&gt;</a>
	</p>
</c:if>