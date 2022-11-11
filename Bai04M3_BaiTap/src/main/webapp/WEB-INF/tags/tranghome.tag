<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" type="String"%>
<%@attribute name="content" fragment="true" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${title}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body style="background-color: #f8f8f8;">
	<div class="container">
		<div class="header">
			<p id="tittle">MODULE 3: LẬP TRÌNH WEB VỚI JAVA</p>
		</div>
		<div class="content">
			<div class="sidebar-left">

				<ul>
					<li><a href="helloworld.html">Hello World</a></li>
					<li><a href="sumtwonumbers.html">Sum Two Numbers</a></li>
					<li><a href="summultinumbers.html">Sum Multiple Numbers</a></li>
					<li><a href="register.jsp">Register</a></li>
					<li><a href="login.jsp">Login</a></li>
					<li><a href="multiplicationtable.jsp">Multiplication Table</a></li>
					<li><a href="upload.html">Upload Image</a></li>
					<li><a href="views/upload/multi_upload.jsp">Multiple
							Upload Image</a></li>
					<li><a href="template.jsp">Template Example</a></li>
					<li><a href="category.html">Category</a></li>
				</ul>

			</div>
			<div class="section">
				<jsp:invoke fragment="content"/>
			</div>
		</div>



	</div>
	<div class="footer"></div>
	</div>
</body>

</html>