<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.sql.Connection" %>
 <%@page import="java.sql.Statement" %>
 <%@page import="java.sql.ResultSet" %>
 <%@page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/qlbansua?useUsenicode=true&characterEncoding=UTF-8";
	String user = "root";
	String password = "";
	Connection conn = DriverManager.getConnection(url, user, password);
	String sql = "select * from loai_sua";
	Statement stm = conn.createStatement();
	ResultSet rs = stm.executeQuery(sql);
%>


</head>

<body>
	<table border="1">
		<caption>DANH SÁCH LOẠI SỮA</caption>
		<tr>
		<td>Mã loại</td>
		<td>Tên loại</td>
		</tr>
		<%
			while(rs.next()){
		%>
		<tr>
			<td><%=rs.getString("Ma_loai_sua")%></td>
			<td><%=rs.getString("Ten_loai")%></td>
		</tr>
		
		<%} %>
	</table>

</body>
</html>