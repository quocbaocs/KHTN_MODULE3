<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="me"%>
<me:tranghome title="Trang chu">
	<jsp:attribute name="content">
		<div class="product-list">
			<c:forEach items="${dssp}" var="sp">
					<div class="product-item">
						<img src="images/product/${sp.imageUrl }">
						<p><a href="home/detail.html?id=${sp.productId}">${sp.title}</a></p>
					</div>
				</c:forEach>
				<div class="center">
					<div class="pagination">
					  <a href="#">&laquo;</a>
					  <c:forEach begin="1" end="${tongSoTrang}" step="1" var="i">
					  	<a href="?trang=${i}" class="${param.trang eq i ? 'active':'' }">${i}</a>
					  </c:forEach>
					  <a href="#">&raquo;</a>
					 </div>
				</div>
				</div>
				
	</jsp:attribute>
</me:tranghome>