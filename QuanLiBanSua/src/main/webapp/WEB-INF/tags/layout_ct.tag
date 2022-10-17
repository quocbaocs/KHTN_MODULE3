<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" type="String"%>
<%@attribute name="content"  fragment="true"%>
<%@attribute name="nav"  fragment="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${title}</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<table width=900px>
		<tr>
			<td colspan=3><a href="bai_12_qltrang.jsp"><img
					src="images/Baner.jpg" width="1000px" height="150px"></a></td>
		</tr>
		<tr>
			<td width=30% valign="top">
				<table width=100%">
                   <tr>
                   	<td> <img src="images/icon_homepage.gif">
		<a href="bai_12_qltrang.jsp">Trang chủ</a></td>
                   </tr>
                   <tr>
                   	<td><img src="images/icon_insert.jpg"
					width="16px" height="16">
		<a href="bai_10_them_sua_moi.jsp">Thêm
                    mới sữa</a></td>
                   </tr>
                   <tr>
                   	<td><img src="images/ba_gai_1.jpg" width="16px"
					height="16">
		<a href="bai_10_them_sua_moi.jsp">Sữa bán chạy</a></td>
                   </tr>
                   <tr>
                   	<td> <img src="images/icon_search.gif">
		<a href="bai_9_tim_kiem_thong_tin_sua_nc.jsp">Tìm kiếm sữa</a></td>
                   </tr>
                   <tr>
                   	<td><img src="images/icon_user.png">
		<a href="bai_11_capnhat_xoa_thongtin_khachhang.jsp">Khách
                    hàng</a></td>
                   </tr>
                    <tr>
                        <td>
                            <img alt="" src="images/menu/animation_milk.gif">
                             <img alt="" src="images/menu/animation_ecard.gif">
                        </td>
                    </tr>
                </table>
			</td>
			<td width=70% valign="top" id="mainArticle">
				<jsp:invoke fragment="content" />
			</td>
		</tr>
		<tr>
			<td align=center colspan=3 id="footer"><br>
			<br>
				<p align="center">
					&copy; 2007 -2008 Siêu thị sữa Happy Milk<br> Địa chỉ: Số 1
					bis Đường Nguyễn Du Quận I TP.HCM - Điện thoại: (08) 874 1258<br>
					<img src="images/icon_address.gif">&nbsp;happy_milk@milk.com.vn
				</p> <br>
			<br></td>
		</tr>
	</table>
</body>
</html>