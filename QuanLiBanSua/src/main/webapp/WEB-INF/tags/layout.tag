<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" type="String"%>
<%@attribute name="content"  fragment="true"%>
<%@attribute name="nav"  fragment="true"%>
<%@attribute name="siteAds" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${title}</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<table width=900px>
		<tr>
			<td colspan=3><a href="bai_12_qltrang.jsp"><img
					src="images/Baner.jpg" width="1000px" height="150px"></a></td>
		</tr>
		<tr>
			<td width=20% valign="top">
				<jsp:invoke fragment="nav" />
			</td>
			<td width=70% valign="top" id="mainArticle">
				<jsp:invoke fragment="content" />
			</td>
			
			<td width=10% valign=top id="siteAds">
				<jsp:invoke fragment="siteAds" />
			</td>
		</tr>
		<tr>
			<td align=center colspan=3 id="footer"><br>
			<br>
				<p align="center">
					&copy; 2007 -2008 Siêu thị sữa Happy Milk<br> Địa chỉ: Số 1
					bis Đường Nguyễn Du Quận I TP.HCM - Điện thoại: (08) 874 1258<br>
					<img src="images/icon_address.gif">&nbsp;happy_milk@milk.com.vn
				</p> <br>
			<br></td>
		</tr>
	</table>
</body>
</html>