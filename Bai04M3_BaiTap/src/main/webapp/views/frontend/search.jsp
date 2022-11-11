<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="me"%>
<me:tranghome title="Trang chu">
	<jsp:attribute name="content">

	<div class="product-search">
		<form action="search.html" method="get">
		<input type="text" name="keyword">
			<button type="submit" value="btnSeacrh">Search</button>
		</form>
	</div>
	<h3>Search Result</h3>
		<div class="product-list">
			<c:forEach items="${dssp}" var="sp">
					<div class="product-item">
						<img src="../images/product/${sp.imageUrl }">
						<p>
						<a href="detail.html?id=${sp.productId}">${sp.title}</a>
					</p>
					</div>
				</c:forEach>
		</div>
				
	</jsp:attribute>
</me:tranghome>