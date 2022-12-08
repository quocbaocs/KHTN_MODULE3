<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table style="width: 100%;background-color: orange;">
	<tr>
		<th style="background-color: red; color: white;"><span>Sản
				phẩm theo hãng sữa</span></th>
	</tr>
	<c:forEach items="${dshs}" var="hs">
		<tr>
			<td><a href="?maHang=${hs.maHang}" style="color: ${param.maHang==hs.maHang?"red":""}">${hs.tenHang}</a></td>
		</tr>
	</c:forEach>
	<tr>
		<th style="background-color: red; color: white;"><span>Sản
				phẩm theo loại</span></th>
	</tr>

	<c:forEach items="${dsls}" var="ls">
		<tr>
			<td><a href="?maLoai=${ls.maLoai}" style="color: ${param.maLoai==ls.maLoai?"red":""}">${ls.tenLoai}</a></td>
		</tr>
	</c:forEach>
	<tr>
		<td><img src="images/milk.jpg" width="100%" height="215px"></td>
	</tr>
</table>