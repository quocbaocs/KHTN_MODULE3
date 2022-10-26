<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Trang chủ</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<table>
		
		<tr>
			<td bgcolor="#b5dcb3" height="200" width="60%" class="content">
			<jsp:include page="nav.jsp"></jsp:include>
				<jsp:directive.include file="danh_muc_sua_loai_hang.jsp"/>
			</td>

			<td bgcolor="#aaa" width="20%">
			<jsp:directive.include file="menu_phai.jsp"/>
			</td>
		</tr>
		<tr valign="bottom" align="center" style="color: white;">
			<td bgcolor="# 1E90FF" width="100%" colspan="3">
				<jsp:directive.include file="footer.jsp"/>
			</td>

			
		</tr>
	</table>
</body>
</html>