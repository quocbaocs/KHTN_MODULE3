<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Trang ví dụ minh họa dùng JSP tag --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ví dụ 1</title>
<%! 
	int a =2;
	int cong(int x, int y){
		return x + y;
	}
%>
<%
	int b =3;
	int tong=cong(a,b);
%> 
</head>
<body>
<jsp:directive.include  file="index.jsp"/>
<h1>Tổng: <%=a %>+<%=b %>=<%=a+b%></h1>
<h1>Tổng: <%=a %>+<%=b %>=<%=tong%></h1>
</body>
</html>