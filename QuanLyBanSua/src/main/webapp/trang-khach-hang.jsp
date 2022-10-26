<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Trang chủ admin</title>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <style>
      .tblnv tr:nth-child(odd){
        background-color: yellow;
      }
      .tblnv tr:nth-child(even){
        background-color: lightyellow;
      }
    </style>
</head>

<body>
    <header>
       
           <jsp:include page="views/header.jsp"/>

    </header>
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-2" style="padding: 0;">
                    <jsp:include page="views/nav.jsp"/>
                </div>
                <div class="col-lg-10" style="padding: 0;">
                    <jsp:include page="ListKhachHangServlet"/>

                </div>
            </div>
            </div>
    </section>
    <!-- Hero Section End -->



    <!-- Footer Section Begin -->
    <footer>

        <div class="container">
            <jsp:include page="views/footer.jsp"/>
        </div>

    </footer>
    <!-- Footer Section End -->


</body>

</html>