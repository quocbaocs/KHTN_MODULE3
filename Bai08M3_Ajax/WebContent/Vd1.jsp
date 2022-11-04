<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chao() {
		var obTen = document.getElementById("ten");
		var ten = obTen.value;
		var obLoiChao = document.getElementById("loiChao");
		obLoiChao.innerHTML = "Chào mừng bạn " + ten
				+ " đến với lập trình Ajax";
	}
</script>
</head>
<body>
	<p>
		<label>Nhập họ tên:</label><input type="text" id="ten">
	</p>
	<p id="loiChao" style="font-size: 25px; color: blue; font-weight: bold;"></p>
	<p>
		<button onclick="chao()">Chào</button>
</body>
</html>