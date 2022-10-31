<%@page import="javaBeans.LoaiSua"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expresstion Language (EL)</title>

<%
//1. Biến đơn
int a = 2;

//Sử dụng EL phải bắt đặt vào thuộc tính của ứng dụng web
request.setAttribute("a", a);

//2. Biến mảng
int[] b = { 1, 2, 3, 4, 5 };
request.setAttribute("b", b);

//3 List
List<String> ds = Arrays.asList("mai", "lan", "cuc", "truc");
request.setAttribute("ds", ds);

//4 Map
Map<String, String> td = new TreeMap<String, String>();
td.put("one", "một");
td.put("three", "ba");
td.put("two", "hai");
application.setAttribute("td", td);

//5. java bean
LoaiSua ls = new LoaiSua();
ls.setMaLoai("AA");
ls.setTenLoai("Sữa AA");
request.setAttribute("ls", ls);
%>
</head>
<body>
	<p>a =<%=a%></p>
	<p>a = ${a}</p>
	<p>b =<%=b[2]%></p>
	<p>b = ${b[2] }</p>
	<p>ds[2] =<%=ds.get(2)%></p>
	<p>ds[2] = ${ds[2] }</p>
	<p>td["two"] =<%=td.get("two")%></p>
	<p>td["two"] = ${td["two"] }</p>
	<p>Mã loại <%=ls.getMaLoai() %> Tên loại <%=ls.getTenLoai() %></p>
	<p>Mã loại ${ls.maLoai} Tên loại ${ls.tenLoai}</p>
	<p>Tên: <%=request.getParameter("ten") %></p>
	<p>Tên:${param.ten}</p> 


</body>
</html>