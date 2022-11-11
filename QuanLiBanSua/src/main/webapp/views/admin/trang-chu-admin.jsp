<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="me"%>

<me:home-admin title="Trang chu">
	<jsp:attribute name="content">
		 <div class="aside-left">
                <table id="tbl-cate">
                    <tr class="title-cate">
                        <td>Sản phẩm theo hãng sữa</td>
                    </tr>
                    <tr>
                        <td>
                            <ul>
                            <c:forEach items="${dshs }" var="hs">
                                <li> <a href="danh-sach-san-pham?maHang=${hs.maHangSua}"> ${hs.tenHangSua}</a></li>
                              </c:forEach>
                            </ul>
                        </td>
                    </tr>
                    <tr class="title-cate">
                        <td>Sản phẩm theo loại</td>
                    </tr>
                    <tr>
                        <td>
                            <ul>
                               <c:forEach items="${dsls }" var="ls">
                                <li> <a href="danh-sach-san-pham?maLoai=${ls.maLoaiSua}"> ${ls.tenLoai}</a></li>
                              </c:forEach>
                            </ul>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td>
                            <img alt=""
						src="${pageContext.request.contextPath }/images/icons/milk.jpg"
						width="100%">
                        </td>
                    </tr>
                </table>

            </div>
            <div class="main-content">
                <!--Nav -->
                <div>


                    <img
					src="${pageContext.request.contextPath }/images/icons/icon_homepage.gif"><a
					href="trang-chu">Trang chủ</a>
                    <img
					src="${pageContext.request.contextPath }/images/icons/icon_insert.jpg"
					width="16px" height="16"><a href="them-sua">Thêm
                        mới sữa</a>
                    <img
					src="${pageContext.request.contextPath }/images/icons/ba_gai_1.jpg"
					width="16px" height="16"><a href="them-sua">Sữa bán
                        chạy</a>
                    <img
					src="${pageContext.request.contextPath }/images/icons/icon_search.gif"><a
					href="tim-sua">Tìm kiếm sữa</a>
                    <img
					src="${pageContext.request.contextPath }/images/icons/icon_user.png"><a
					href="khach-hang">Khách
                        hàng</a>
                </div>
                <!-- end nav-->
                <div class="danh-muc-san-pham">
                    <table class="tbldanhmuc">
                        <caption style="color: red;" align="center">
                            <h3>DANH MỤC SẢN PHẨM</h3>
                        </caption>
                        <tr>
                            <td>Hình</td>
                            <td>Tên sữa</td>
                            <td>Trọng lượng <br>(gr)</td>
                            <td>Đơn giá<br>(VNĐ)</td>
                        </tr>
                        <c:forEach items="${dssp}" var="sp">
                        <tr>
                            <td><img
							src="${pageContext.request.contextPath }/images/products/${sp.hinh}"
							style="width: 30px; height: 40px;"></td>
                            <td><a href="san-pham?maSua=${sp.maSua}">${sp.tenSua}</a></td>
                            <td>${sp.trongLuong } gr</td>
                            <td><fmt:formatNumber value="${sp.donGia}"/> VNĐ</td>
                        </tr>
                        </c:forEach>
                    </table>
                     <br>
	               <div class="pagination" >
	             
						   <a href="?trang=1">&lt;&lt;</a>
						   <a href="?trang=${param.trang-1<1?1:param.trang-1}">&lt;</a>
						  <c:forEach begin="1" end="${tongSoTrang}" var="i" step="1">
						 	 <a class="${param.trang eq i ? 'active':'' }" href="?trang=${i}">${i}</a>
						  </c:forEach>
						  
						  <a href="?trang=${param.trang+1>tongSoTrang?tongSoTrang:param.trang+1}">&gt;</a>
						  <a href="?trang=${tongSoTrang}">&gt;&gt;</a>
						  
					</div> 
                </div>
            </div>
            <div class="aside-right">
                <img
				src="${pageContext.request.contextPath }/images/icons/Logo_30nam.gif">
                <img
				src="${pageContext.request.contextPath }/images/icons/1891_vn.gif">
                <img
				src="${pageContext.request.contextPath }/images/icons/Thoitiet1.jpg">
                <img
				src="${pageContext.request.contextPath }/images/icons/pic_functional.jpg">
                <img
				src="${pageContext.request.contextPath }/images/icons/pic_km.jpg">
                <img
				src="${pageContext.request.contextPath }/images/icons/pic_new.jpg">
                <img
				src="${pageContext.request.contextPath }/images/icons/Logo_CauChuyenVinamilk.gif">
            </div>
	</jsp:attribute>
</me:home-admin>