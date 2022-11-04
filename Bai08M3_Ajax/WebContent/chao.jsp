<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chào</title>
<%
	String lc = "";
	if(request.getParameter("btnChao")!=null){
		lc = "Chào mừng bạn "+request.getParameter("ten")+" đến với lập trình AJAX";	
	}
%>
</head>
<body>
	<form>
		<p><label>Nhập họ tên:</label><input type="text" id="ten" name="ten"></p>
		<p><input type="text" name="loiChao" value="<%=lc%>" size="50"></p>
		<p><button type="submit" name="btnChao">Chào</button></p>
	</form>

</body>
</html>