<%-- 
    Document   : ban-chay-yeu-thich
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <div class="product-widget-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">Top Sellers</h2>
                        <a href="" class="wid-view-more">Danh sách</a>
                        <c:forEach var="sp" items="${dsBanChay}">
                        <div class="single-wid-product">
                            <a href="trang-san-pham.jsp?id=${sp.id}"><img src="img/${sp.hinhAnh}" alt="${sp.hinhAnh}" class="product-thumb"></a>
                            <h2><a href="trang-san-pham.jsp?id=${sp.id}">${sp.tenSanPham }</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins><fmt:formatNumber type="number" maxFractionDigits="3"  value="${sp.donGia}" /> vnđ</ins> <del><fmt:formatNumber type="number" maxFractionDigits="3"  value="${sp.donGiaKM}" /> vnđ</del>
                            </div>                            
                        </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="single-product-widget">
                  
                        <h2 class="product-wid-title">Giảm nhiều nhất</h2>
                        <a href="#" class="wid-view-more">Danh sách</a>
                          <c:forEach var="sp" items="${dsGiamGia}">
                        <div class="single-wid-product">
                            <a href="trang-san-pham.jsp?id=${sp.id}"><img src="img/${sp.hinhAnh}" alt="${sp.hinhAnh}" class="product-thumb"></a>
                            <h2><a href="trang-san-pham.jsp?id=${sp.id}">${sp.tenSanPham}</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins><fmt:formatNumber type="number" maxFractionDigits="3"  value="${sp.donGia}" /> vnđ</ins> <del><fmt:formatNumber type="number" maxFractionDigits="3"  value="${sp.donGiaKM}" /> vnđ</del>
                            </div>                            
                        </div>
                        </c:forEach>
                        
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">Yêu thích nhất</h2>
                        <a href="#" class="wid-view-more">Danh sách</a>
                         <c:forEach var="sp" items="${dsYeuThich}">
                        <div class="single-wid-product">
                            <a href="trang-san-pham.jsp?id=${sp.id}"><img src="img/${sp.hinhAnh}" alt="${sp.tenSanPham}" class="product-thumb"></a>
                            <h2><a href="trang-san-pham.jsp?id=${sp.id}">${sp.tenSanPham}</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins><fmt:formatNumber type="number" maxFractionDigits="3"  value="${sp.donGia}" /> vnđ</ins> <del><fmt:formatNumber type="number" maxFractionDigits="3"  value="${sp.donGiaKM}" /> vnđ</del>
                            </div>                            
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End product widget area -->
