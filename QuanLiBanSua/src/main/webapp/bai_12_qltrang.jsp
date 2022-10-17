<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="m"%>
<m:layout title="Xin chào">
	<jsp:attribute name="nav">
		<table class="tblmenu">
                    <tr style="background-color: brown; color: white;">
                        <td>Sản phẩm theo hãng sữa</td>
                    </tr>
                    <tr>
                        <td>
                            <ul>
                                <li> SP1</li>
                                <li> SP1</li>
                                <li> SP1</li>
                                <li> SP1</li>
                                <li> SP1</li>

                            </ul>
                        </td>
                    </tr>
                    <tr style="background-color: brown; color: white;">
                        <td>Sản phẩm theo loại</td>
                    </tr>
                    <tr>
                        <td>
                            <ul>
                                <li> SP1</li>
                                <li> SP1</li>
                                <li> SP1</li>
                                <li> SP1</li>
                                <li> SP1</li>
                            </ul>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td>
                            <img alt="" src="images/menu/milk.jpg"
					style="margin-top: 15px;" width="100%">
                        </td>
                    </tr>
                </table>
	</jsp:attribute>
	<jsp:attribute name="content">
	<!--Nav -->
                <img src="images/icon_homepage.gif">
		<a href="bai_12_qltrang.jsp">Trang chủ</a>
                <img src="images/icon_insert.jpg" width="16px"
			height="16">
		<a href="bai_10_them_sua_moi.jsp">Thêm
                    mới sữa</a>
                    <img src="images/ba_gai_1.jpg" width="16px"
			height="16">
		<a href="bai_10_them_sua_moi.jsp">Sữa bán chạy</a>
                <img src="images/icon_search.gif">
		<a href="bai_9_tim_kiem_thong_tin_sua_nc.jsp">Tìm kiếm sữa</a>
                <img src="images/icon_user.png">
		<a href="bai_11_capnhat_xoa_thongtin_khachhang.jsp">Khách
                    hàng</a>

                <!-- end nav-->
                <h3 style="color: red;" align="center">DANH MỤC SẢN PHẨM</h3>
                <table class="tbldanhmuc">
                    <tr align="center" bgcolor=" #ffe0c1"
				style="font-weight: bold;">
                        <td>Hình</td>
                        <td>Tên sữa</td>
                        <td>Trọng lượng <br>(gr)</td>
                        <td>Đơn giá<br>(VNĐ)</td>
                    </tr>
                    <tr>
                        <td><img
					src="images/sanpham/nuti_iq_mum.jpg"
					style="width: 30px; height: 40px;"></td>
                        <td><a href="chi_tiet_san_pham.html">Gain Advance</a></td>
                        <td>400 gr</td>
                        <td>70.000 VNĐ</td>

                    
			<tr>
                        <td><img
					src="images/sanpham/nuti_iq_mum.jpg"
					style="width: 30px; height: 40px;"></td>
                        <td><a href="chi_tiet_san_pham.html">Gain Advance</a></td>
                        <td>400 gr</td>
                        <td>70.000 VNĐ</td>
                    </tr>
                    <tr>
                        <td><img
					src="images/sanpham/nuti_iq_mum.jpg"
					style="width: 30px; height: 40px;"></td>
                        <td><a href="chi_tiet_san_pham.html">Gain Advance</a></td>
                        <td>400 gr</td>
                        <td>70.000 VNĐ</td>
                    </tr>
                    <tr>
                        <td><img
					src="images/sanpham/nuti_iq_mum.jpg"
					style="width: 30px; height: 40px;"></td>
                        <td><a href="chi_tiet_san_pham.html">Gain Advance</a></td>
                        <td>400 gr</td>
                        <td>70.000 VNĐ</td>
                    </tr>
                    <tr>
                        <td><img
					src="images/sanpham/nuti_iq_mum.jpg"
					style="width: 30px; height: 40px;"></td>
                        <td><a href="chi_tiet_san_pham.html">Gain Advance</a></td>
                        <td>400 gr</td>
                        <td>70.000 VNĐ</td>
                    </tr>
                    <tr>
                        <td><img
					src="images/sanpham/nuti_iq_mum.jpg"
					style="width: 30px; height: 40px;"></td>
                        <td><a href="chi_tiet_san_pham.html">Gain Advance</a></td>
                        <td>400 gr</td>
                        <td>70.000 VNĐ</td>
                    </tr>
</table>
</jsp:attribute>
<jsp:attribute name="siteAds">
<img src="images/menu/Logo_30nam.gif"><br>
        <img src="images/menu/1891_vn.gif" width="151px"><br>
        <img src="images/menu/Thoitiet1.jpg"><br>
        <img src="images/menu/pic_functional.jpg"><br>
        <img src="images/menu/pic_km.jpg"><br>
        <img src="images/menu/pic_new.jpg"><br>
        <img src="images/menu/Logo_CauChuyenVinamilk.gif">
</jsp:attribute>
</m:layout>