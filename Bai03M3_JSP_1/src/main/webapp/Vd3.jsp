<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ví dụ 3</title>
</head>
<body>
 <p>Tên đơn vị: <%=application.getAttribute("tenDV") %></p> 
	 <p>Tên  người dùng: <%=session.getAttribute("tenND") %></p>
	 <p>Tên yêu cầu: <%=request.getAttribute("tenYC") %></p>
	 <p>Ngữ cảnh của trang: <%=pageContext.getAttribute("trang") %></p>
</body>
</html>