<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	background-color: white;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: black;
}

* {
	box-sizing: border-box;
}

/* Add padding to containers */
.container {
	margin: auto;
	width: 500px;
	padding: 16px;
	background-color: white;
	padding: 16px;
	width: 500px;
	border: 1px solid black;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

/* Add a blue text color to links */
a {
	color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: #f1f1f1;
	text-align: center;
}
</style>
</head>
<body>

	<form action="register.html" method="post">
		<div class="container signin" style="text-align: left; border-bottom: none;">
			<b">Register</b>
		</div>
		<div class="container">

			<input type="text" placeholder="Full Name" name="fullname"
				id="fullname" required> <input type="text"
				placeholder="Enter Email" name="email" id="email" required>
			<input type="text" placeholder="UserName" name="username"
				id="username" required> <input type="password"
				placeholder="Enter Password" name="password" id="psw" required>
			<select name="gender" style="width: 100px; height: 30px">
				<option value="0">Male</option>
				<option value="1">Female</option>
				<option value="2">Undefined</option>
			</select>
			<button type="submit" class="registerbtn">Register</button>

			<div align="center">
				<p>
					<a href="#">Log On</a>
				</p>
				<br>
				<p>
					<a href="#">Forgot password</a>
				</p>
			</div>
		</div>



	</form>

</body>
</html>
