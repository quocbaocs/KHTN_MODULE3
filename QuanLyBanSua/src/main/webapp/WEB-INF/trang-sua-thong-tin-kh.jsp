<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<table>
		<tr>
			<td colspan=3><jsp:include page="views/header.jsp" /></td>
		</tr>
		<tr>
			<td width=20% valign="top">
				<jsp:include page="views/nav.jsp"/>
			</td>
			<td width=70% valign="top" id="mainArticle" colspan="2">
				<!--Nav --> <!-- end nav--> <!-- begin Chi tiet san pham -->
				<p>${message }</p>
				<jsp:include page="views/update-khach-hang.jsp"/>

			</td>
		</tr>
		<tr>
			<jsp:include page="views/footer.jsp" />
		</tr>
	</table>
</body>
</html>