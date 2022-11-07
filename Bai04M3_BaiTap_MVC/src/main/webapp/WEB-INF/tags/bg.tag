<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"%>
<%@attribute name="content" required="true" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="title">
		<div class="container" >
			<div class="brand" style="position: fixed;">
				<a href="${pageContext.request.contextPath}"> MODULE 3: LẬP
					TRÌNH WEB VỚI JAVA </a>
			</div>
		</div>
	</div>
	<div class="sidebar">
		<ul>
			<li><a href="helloworld.html">Hello World</a></li>
			<li><a href="sumtwonumbers.html">Sum Two Numbers</a></li>
			<li><a href="summultinumbers.html">Sum Multiple Numbers</a></li>
			<li><a href="register.jsp">Register</a></li>
			<li><a href="login.jsp">Login</a></li>
			<li><a href="multiplicationtable.jsp">Multiplication Table</a></li>
			<li><a href="upload.html">Upload Image</a></li>
			<li><a href="views/upload/multi_upload.jsp">Multiple Upload Image</a></li>
			<li><a href="template.jsp">Template Example</a></li>
			<li><a href="category.html">Category</a></li>
		</ul>
	</div>
	<div class="main" style="position: fixed;overflow: auto;height:100%">
		<div>
			<jsp:invoke fragment="content" />
		</div>
	</div>
</body>
</html>