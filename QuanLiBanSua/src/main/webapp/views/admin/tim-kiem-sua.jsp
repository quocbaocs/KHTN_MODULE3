<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="me"%>
<me:template-admin title="Quan li khach hang">
	<jsp:attribute name="content">
		<div class="main-content-1" align="center">
			<div class="frm-timkiem">
				<form action="" method="post">
					<table class="tbltimkiem" style="border-collapse: collapse; width: 100%">
						<tr align="center">
							<td>
								<h3 style="color: red;">TÌM KIẾM THÔNG TIN SỮA</h3>
							</td>
						</tr>
						<tr align="center">
							<td><b>Loại sữa:</b>
								<select name="cboLoaiSua">
									<c:forEach items="${dsls}" var="ls">
										<option value="${ls.maLoaiSua}">${ls.tenLoai}</option>
									</c:forEach>
								</select>
								<b>Hãng sữa:</b>
								<select name="cboHangSua">
									<c:forEach items="${dshs}" var="hs">
										<option value="${hs.maHangSua}">${hs.tenHangSua}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr align="center" style="padding-bottom: 15px;">
							<td><b>Tên sữa: </b><input type="text" name="keyword" size="50" />&nbsp;
								<input type="submit" value="Tìm kiếm"
											style="background-color: rgb(223, 124, 124);">
							</td>
						</tr>
					</table>
				</form>
			</div>
			<c:if test="${message!=null }">
				<div>
					<h4>${message}</h4>
				</div>
			</c:if>
			<c:if test="${dssp!=null }">
				<div class="ketqua-tim">
					<table>
					<c:forEach items="${dssp}" var="sp">
						<tr align="center">
							<td colspan="2" bgcolor="#FFEEE6">
								<h2 style="color: red;">${sp.tenSua}</h2>
							</td>
						</tr>
						<tr>
							<td align="center"><img src="${pageContext.request.contextPath}/images/products/nuti_iq_mum.jpg" width="80px" height="100px"></td>
							<td>
								<b>Thành phần dinh dưỡng:</b><br />
								${sp.tpDinhDuong }
								<br>
								<b>Lợi ích:</b><br />
								${sp.loiIch}
								<br>
								<p><b><i>Trọng lượng:</i></b> ${sp.trongLuong} gr - <b><i>Đơn giá: </i></b> <fmt:formatNumber value="${sp.donGia}"/> VNĐ</p>
				
							</td>
						</tr>
					</c:forEach>
					</table>
				</div>
			</c:if>
        </div>
	</jsp:attribute>
</me:template-admin>

