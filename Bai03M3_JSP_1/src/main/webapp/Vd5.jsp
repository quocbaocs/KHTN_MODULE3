<%@page import="javaBeans.LoaiSua"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>

<%
	List<LoaiSua> dsls = new ArrayList<LoaiSua>();
	LoaiSua ls1 = new LoaiSua();
	ls1.setMaLoai("AA");
	ls1.setTenLoai("Sữa AA");
	
	LoaiSua ls2 = new LoaiSua();
	ls2.setMaLoai("BB");
	ls2.setTenLoai("Sữa BB");
	
	LoaiSua ls3 = new LoaiSua();
	ls3.setMaLoai("CC");
	ls3.setTenLoai("Sữa CC");
	dsls.add(ls1);
	dsls.add(ls2);
	dsls.add(ls3);
	
	request.setAttribute("dsls", dsls);
	
	
	
%>
</head>
<body>
	<p><c:out value="Minh họa sử dụng JSTL"></c:out></p>
	<c:set value="123456" var="so"></c:set>
	<p><c:out value="Giá trị số = ${so}"></c:out></p>
	<fmt:setLocale value="vi-VN"/>
	<fmt:formatNumber value="${so}" var="soVN"></fmt:formatNumber>
	<p>Số VN: ${soVN}</p>
	
	<c:forEach var="i" begin="1" end="3" step="1">
	<p>Đây là dòng thứ  ${i}</p>
	</c:forEach>
	<%
		for(int i =1; i <=3; i++){%>
			<p>Đây là dòng thứ  <%=i %></p>
		<% }
	%>
	
	<c:forEach items="${dsls}" var="ls">
		<p>Mã loại : ${ls.maLoai} Tên loại: ${ls.tenLoai }</p>
	</c:forEach>
	
	<%
	for(LoaiSua ls: dsls){
		%>
		<p>Mã loại: <%=ls.getMaLoai() %> Tên loại: <%=ls.getTenLoai() %></p>
	<%}
	%>
</body>
</html>