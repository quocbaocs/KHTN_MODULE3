<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File</title>
<style type="text/css">
body{
margin: auto;
}
</style>
</head>
<body>
<form action="UploadServlet" method="post" enctype="multipart/form-data">
<h1>Minh họa Upload file</h1>
<p><label>Tập tin:</label><input type="file" name="tapTin" size="15">
<p><input type="submit" name="btnUpload" value="Upload"></p>
</form>
<c:if test="${not empty tenTapTin}">
<p><img src="uploads/${tenTapTin}"></p>
</c:if>
</body>
</html>