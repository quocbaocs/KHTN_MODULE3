<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="loadDoc()">
<table id="demo"></table>
	<button type="button" onclick="loadDoc(2)">Change Content</button>
	<script>
		function loadDoc(ma) {
			var xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				var content = this.responseText;
				var suaObj = eval('(' + content + ')');
				createTable(suaObj);
				//showTableDanhMuc(eval('(' + content + ')'));
			}
			xhttp.open("GET", "demoServlet?id="+ma);
			xhttp.send();
		}
		 function createTable(Obj) {
          
			 let table="<tr><th>Artist</th><th>Title</th></tr>";
			  for (let i = 0; i < Obj.sua.length; i++) {
			    table += "<tr><td>" + Obj.sua[i].masua+
			    "</td><td>" +
			    Obj.sua[i].tensua +
			    "</td></tr>";
			  }
			  document.getElementById("demo").innerHTML = table;
         }
	</script>

</body>
</html>