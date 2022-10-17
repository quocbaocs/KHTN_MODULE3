<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" class="form" enctype="multipart/form-data">
		<p>
			<label>Choose Image</label> <input type="file" name="f">
		</p>
		<p>
			<button class="btn btn-primary">Upload</button>
		</p>
	</form>
	<c:if test="${not empty img}">
		<img width="100"
			src="${pageContext.request.contextPath}/upload/${img}">
	</c:if>

</body>
</html>