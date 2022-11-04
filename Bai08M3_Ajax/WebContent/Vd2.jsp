<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chào</title>
<script type="text/javascript">
	function chao() {

		var obTen = document.getElementById("ten");
		var ten = obTen.value;

		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var tl = this.responseText;
				var oblc = document.getElementById("loiChao");
				oblc.innerHTML = tl;
			}
		}
		xhr.open("get", "Vd2Servlet?ten=" + ten);
		xhr.send();
	}
</script>
</head>
<body>
	<p>
		<label>Nhập họ tên:</label><input type="text" id="ten">
	</p>
	<p id="loiChao"
		style="font-size: 25px; color: blue; font-weight: bold;"></p>
	<p>
		<button onclick="chao();">Chào</button>
</body>
</html>