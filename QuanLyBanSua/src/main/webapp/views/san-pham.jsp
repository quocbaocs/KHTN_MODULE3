<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table class="tblct" style="width: 800px; margin: 0; border: 0">
<tr align="left">
	<td colspan="2" bgcolor="#FFEEE6">
		<h3 style="color: red;">${sp.tenSua }</h3>
	</td>
</tr>
<tr>
	<td align="center"><img src="images/sanpham/${sp.hinh}"
		width="100px" height="120px"></td>
	<td rowspan="2" style="padding-left: 20px;"><b>Thành phần dinh dưỡng:</b><br />
		${sp.tpDinhDuong }<br> <b>Lợi ích:</b><br /> ${sp.loiIch}<br>
		<p>
			<b><i>Trọng lượng:</i></b> <span style="color: red">${sp.trongLuong} gr </span>- <b><i>Đơn
					giá: </i></b>
			<span style="color: red"><fmt:formatNumber value="${sp.donGia}" />
			VNĐ</span>
		</p></td>
</tr>
</table>
