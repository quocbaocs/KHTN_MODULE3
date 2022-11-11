<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="me"%>
<me:template-admin title="Chi tiết sản phẩm">
	<jsp:attribute name="content">
		<div class="main-content-1" align="center">
			<table class="tblttsp">
				<tr align="center">
					<td colspan="2" bgcolor="#FFEEE6">
						<h1 style="color: red;">${sp.tenSua}</h1>
					</td>
				</tr>
				<tr>
					<td align="center"><img src="${pageContext.request.contextPath}/images/products/nuti_iq_mum.jpg"
								width="140px" height="180px"></td>
					<td rowspan="2">
						<b>Thành phần dinh dưỡng:</b><br />
						${sp.tpDinhDuong}
						<br>
						<b>Lợi ích:</b><br />
						${sp.loiIch }
						<br>
						<p align="right">
									<b><i>Trọng lượng:</i></b> ${sp.trongLuong} gr - <b><i>Đơn giá: </i></b><fmt:formatNumber value=""/> VNĐ</p>
					
					</td>
				</tr>
				<tr>
					<td align="right"><a href="#" onclick="javascript:history.go(-1);">Quay về</a></td>
				</tr>
			</table>
        </div>
	</jsp:attribute>
</me:template-admin>