<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="me"%>
<me:tranghome title="Manager Publisher">
	<jsp:attribute name="content">
	<h2 style="font-size: 30px; font-weigth: bold; color: red;">Manage Publisher</h2><br>
	<a href="AddNewPublisherServlet">Add New Publisher</a>
		<table style="width: 100%; margin: 5px; border-collapse: collapse;" border="1">
			<tr>
				<th>Delete</th>
				<th>Id</th>
				<th>Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${publishers}" var="p">
				<tr align="center">
					<td><input type="checkbox" name="idDel"
						value="${p.publisherId}" /></td>
					<td>${p.publisherId}</td>
					<td>${p.publisherName}</td>
					<td><a href="EditPublisherServlet?id=${p.publisherId}"><img src="${pageContext.request.contextPath }/images/icons/edit.png" style="width: 20px; height: 20px;"></a></td>
					<td><a href="DelPublisherServlet?id=${p.publisherId}"><img src="${pageContext.request.contextPath }/images/icons/trash.png" style="width: 20px; height: 20px; "></a></td>
				</tr>
			</c:forEach>
		</table>
	</jsp:attribute>
</me:tranghome>