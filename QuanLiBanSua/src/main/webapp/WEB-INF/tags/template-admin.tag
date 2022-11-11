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
			<a href="bai_12_qltrang.jsp"><img src="${pageContext.request.contextPath }/images/icons/Baner.jpg"
				width="100%"></a>
		</div>
		<div class="content">
			<div class="aside-left-1">
                <ul>
                    <li><img src="${pageContext.request.contextPath }/images/icons/icon_homepage.gif"><a href="trang-chu">Trang chủ</a></li>
                    <li><img src="${pageContext.request.contextPath }/images/icons/icon_insert.jpg" width="16px" height="16"><a
                            href="them-sua">Thêm
                            mới sữa</a></li>
                    <li> <img src="${pageContext.request.contextPath }/images/icons/ba_gai_1.jpg" width="16px" height="16"><a href="them-sua">Sữa
                            bán
                            chạy</a></li>
                    <li> <img src="${pageContext.request.contextPath }/images/icons/icon_search.gif"><a href="tim-sua">Tìm kiếm
                            sữa</a></li>
                    <li> <img src="${pageContext.request.contextPath }/images/icons/icon_user.png"><a href="khach-hang">Khách
                            hàng</a></li>
                    <li style="background-color: white;"><img src="${pageContext.request.contextPath }/images/icons/animation_ecard.gif">
                    <img src="${pageContext.request.contextPath }/images/icons/animation_milk.gif"></li>
                </ul>
            </div>
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
