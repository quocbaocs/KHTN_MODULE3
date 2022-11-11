<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" type="String"%>
<%@attribute name="content" fragment="true"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${title}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
</head>

<body>
	<div class="container">
		<div id="header">
			<a href="trang-chu"><img src="${pageContext.request.contextPath }/images/icons/Baner.jpg"
				width="100%"></a>
		</div>
		<div class="content">
			
			<jsp:invoke fragment="content"></jsp:invoke>

		</div>
		<div id="footer">
			<br>
			<p align="center">
				&copy; 2007 -2008 Siêu thị sữa Happy Milk<br> Địa chỉ: Số 1 bis
				Đường Nguyễn Du Quận I TP.HCM - Điện thoại: (08) 874 1258<br> <img
					src="${pageContext.request.contextPath }/images/icons/icon_address.gif">&nbsp;happy_milk@milk.com.vn
			</p>
			<br>
		</div>
	</div>
</body>

</html>
