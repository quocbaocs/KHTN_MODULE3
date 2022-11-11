<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="me"%>
<me:tranghome title="Manager Publisher">
	<jsp:attribute name="content">
	<form action="search.html" method="get">
		<input type="text" name="keyword"><button type="submit" value="btnSeacrh">Search</button>
	</form>
	<h2 style="font-size: 30px; font-weigth: bold; color: red;">Product Detail</h2><br>
		<div id="single-product" style="display: flex; margin-left: 20px">
			<div class="single-photo">
				<img alt="" src="../images/product/${sp.imageUrl }">
			</div>
			<div class="detail-product" style="padding-left: 20px; line-height: 1.5;">
				<h3>${sp.title }</h3>
				<p>ISBN: <b>${sp.isbn}</b></p>
				<p>Pages: <b>${sp.pages }</b></p>
				<p>Price: <b>${sp.price }</b></p>
				<p><input type="number" min="1" max="30" value="1" step="1" style="width: 100px"><button type="submit" style="margin-left: 10px">Add to cart</button></p>
			</div>
		</div>
	</jsp:attribute>
</me:tranghome>