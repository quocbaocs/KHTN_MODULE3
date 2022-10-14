<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="tieuDe" type="String"%>
<%@ attribute name="noiDung" fragment="true"%>
<html>
<head>
<meta charset="UTF-8">
<title>${tieuDe}</title>
<!-- Internal stylesheet -->
<style type="text/css">
main {
	display: flex;
	width: 100%;
}

header, footer {
	background-color: lightblue;
	height: 100px;
	padding: 10px;
}

nav {
	width: 20%;
	background-color: khaki;
}

article {
	width: 80%;
	background-color: lightyellow;
}
</style>

</head>
<body>
	<header>
		<h1>Minh họa Template</h1>
	</header>
	<main>
		<nav>
			<ul>
				<li><a href="tem1.jsp">Temp1</a></li>
				<li><a href="chao.jsp">Chao</a></li>
				<li>Thực đơn 3</li>
				<li></li>
			</ul>
		</nav>
		<article>
			<jsp:invoke fragment="noiDung"></jsp:invoke>
		</article>
	</main>
	<footer>
		<h4>Trang mẫu 01</h4>
	</footer>
</body>
</html>