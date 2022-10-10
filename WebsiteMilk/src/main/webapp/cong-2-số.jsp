<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cộng hai số</title>

<%
	String a ="", b="", kq="";
	if(request.getParameter("btnTinh")!=null){
		a = request.getParameter("txtSoA");
		b = request.getParameter("txtSoB");
		double k = Double.parseDouble(a)+Double.parseDouble(b);
		kq =String.valueOf(k);
	}
%>
</head>
<body>
<form action="" method="post">
	<h1>Minh họa cộng hai số</h1>
	<p><label>Số a: </label><input type="text" name="txtSoA" value="<%=a %>"></p>
	<p><label>Số b: </label><input type="text" name="txtSoB" value="<%=b %>"></p>
	<p><label>Kêt quả: </label><input type="text" name="txtKQ" value="<%=kq%>"></p>
	<p><input type="submit" name="btnTinh" value="Tính"></p>
</form>

</body>
</html>