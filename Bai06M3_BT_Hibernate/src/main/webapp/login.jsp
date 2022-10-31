<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form method="post" class="form">
		<p>
			<label>Username</label> <input type="text" name="usr">
		</p>
		<p>
			<label>Password</label> <input type="password" name="pwd">
		</p>
		<p>
			<button>Login</button>
		</p>
	</form>
	<c:if test="${pageContext.request.method == 'POST'}">
		<p>Username: ${param.usr}</p>
		<p>Password: ${param.pwd}</p>
	</c:if>
</body>
</html>