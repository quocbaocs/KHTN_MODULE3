<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="eng">
<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Trang chủ admin</title>
<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">
<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
	<header>
		<jsp:include page="views/header.jsp"/>
	</header>
	<section class="hero">
		<div class="container">
			<div class="row">
				<div class="col-lg-2" style="padding: 0;">
					<jsp:include page="HangLoaiServlet" />
				</div>
				<div class="col-lg-8">
					<!-- nav -->
					<img src="images/nav/icon_homepage.gif"> <a
						href="bai-12-qltrang.jsp">Trang chủ</a> <img
						src="images/nav/icon_insert.jpg" width="16px" height="16"> <a
						href="trang-them-sua.jsp">Thêm mới sữa</a> <img
						src="images/nav/icon_search.gif"> <a href="trang-tim-sua.jsp">Tìm
						kiếm sữa</a> <img src="images/nav/icon_user.png"> <a
						href="trang-khach-hang.jsp">Khách hàng</a>

					<!-- end nav -->
					<br>
					<!-- begin danh muc san pham -->

					<h3 style="color: red;" align="center">DANH MỤC SẢN PHẨM</h3>

					<jsp:include page="DanhMucSuaServlet" />
					<!-- end danh muc san pham-->

				</div>
				<div class="col-lg-2" style="padding: 0;">
					<jsp:include page="views/menu-phai.jsp" />
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->



	<!-- Footer Section Begin -->
	<footer>

		<div class="container">
			<jsp:include page="views/footer.jsp"></jsp:include>
		</div>

	</footer>
	<!-- Footer Section End -->


</body>

</html>