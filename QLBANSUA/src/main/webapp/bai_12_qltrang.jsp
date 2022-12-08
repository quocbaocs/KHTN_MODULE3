<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <table width=900px>
        <tr>
            <td colspan=3>

                <jsp:include page="header.jsp"/>

            </td>
        </tr>
        <tr>
            <td width=20% valign="top">
                <%@include file="menu_trai.jsp" %>
            </td>
            <td width=70% valign="top" id="mainArticle">
                <!--Nav -->
                <img src="images/icon_homepage.gif"><a href="bai_12_qltrang.jsp">Trang chủ</a>
                <img src="images/icon_insert.jpg" width="16px" height="16"><a href="bai_10_them_sua_moi.jsp">Thêm
                    mới sữa</a>
                    <img src="images/ba_gai_1.jpg" width="16px" height="16"><a href="bai_10_them_sua_moi.jsp">Sữa bán chạy</a>
                <img src="images/icon_search.gif"><a href="bai_9_tim_kiem_thong_tin_sua_nc.jsp">Tìm kiếm sữa</a>
                <img src="images/icon_user.png"><a href="bai_11_capnhat_xoa_thongtin_khachhang.jsp">Khách
                    hàng</a>

                <!-- end nav-->
                <h3 style="color: red;" align="center">DANH MỤC SẢN PHẨM</h3>
                <jsp:include page="danh_muc_sua_loai_hang.jsp"/>

    </td>
    <td width=10% valign=top id="siteAds">
        <img src="images/menu/Logo_30nam.gif"><br>
        <img src="images/menu/1891_vn.gif" width="151px"><br>
        <img src="images/menu/Thoitiet1.jpg"><br>
        <img src="images/menu/pic_functional.jpg"><br>
        <img src="images/menu/pic_km.jpg"><br>
        <img src="images/menu/pic_new.jpg"><br>
        <img src="images/menu/Logo_CauChuyenVinamilk.gif">
    </td>
    </tr>
    <tr>
        <td align=center colspan=3 id="footer">
            <br><br>
            <p align="center">
                &copy; 2007 -2008 Siêu thị sữa Happy Milk<br>
                Địa chỉ: Số 1 bis Đường Nguyễn Du Quận I TP.HCM - Điện thoại: (08) 874 1258<br>
                <img src="images/icon_address.gif">&nbsp;happy_milk@milk.com.vn
            </p>
            <br><br>
        </td>
    </tr>
    </table>
</body>

</html>