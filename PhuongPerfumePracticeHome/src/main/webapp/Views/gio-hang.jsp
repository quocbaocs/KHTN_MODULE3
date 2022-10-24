<%-- 
    Document   : gio-hang
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2>Shopping Cart</h2>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End Page title area -->
    
    <c:set var="cart" value="${sessionScope['cart']}"/>
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Tìm kiếm</h2>
                        <form action="#" method="post">
                            <input type="text" placeholder="Thông tin tìm kiếm..." name="keyword">
                            <input type="submit" value="Tìm">
                        </form>
                    </div>
                    
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Sản phẩm</h2>
                        <c:forEach var="sp" items="${dsTim}">
                        <div class="thubmnail-recent">
                            <img src="img/${sp.hinhAnh}" class="recent-thumb" alt="">
                            <h2><a href="trang-san-pham.jsp?id=${sp.id}">${sp.tenSanPham}</a></h2>
                            <div class="product-sidebar-price">
                                <ins><fmt:formatNumber value="${sp.donGia}"/> vnđ</ins> <del><fmt:formatNumber value="${sp.donGiaKM}"/> vnđ</del>
                            </div>                             
                        </div>
 						</c:forEach>
                    </div>
                </div>
                
                <div class="col-md-8">
                    <div class="product-content-right">
                        <div class="woocommerce">
                           
                                <table cellspacing="0" class="shop_table cart">
                                    <thead>
                                        <tr>
                                            <th class="product-remove">Xóa</th>
                                            <th>Cập nhật</th>
                                            <th class="product-thumbnail">Hình</th>
                                            <th class="product-name">Product</th>
                                            <th class="product-price">Price</th>
                                            <th class="product-quantity">Quantity</th>
                                            <th class="product-subtotal">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                    <c:forEach items="${cart.gioHang}" var="item">
                                        <tr class="cart_item">
                                         <form method="get" action="xoa-product">
                                            <td class="product-remove">
                                                <input title="update this item" class="update" type="submit" title="update this item" class="update" value="X" style="background-color: blue;color: white;">
                                                <input type="hidden" value="${item.key.id}" name="id">
                                            </td>
                                            </form>
                                            <form method="get" action="update-cart">
                                              <td class="product-remove">
                                                <input title="update this item" class="update" style="background-color: blue;color: white;" type="submit" value="C">
                                                <input type="hidden" name="id" value="${item.key.id}">
                                            
                                            </td>

                                            <td class="product-thumbnail">
                                                <a href="single-product.html"><img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src="img/${item.key.hinhAnh }"></a>
                                            </td>

                                            <td class="product-name">
                                                <a href="single-product.html">${item.key.tenSanPham}</a> 
                                            </td>

                                            <td class="product-price">
                                                <span class="amount"><fmt:formatNumber value="${item.key.donGia}"/></span> 
                                            </td>

                                            <td class="product-quantity">
                                                <div class="quantity buttons_added">
                                                    <input type="number" class="input-text qty text" title="Qty"  value="${item.value}" min="0" step="1" name="quantity">
                                                </div>
                                            </td>

                                            <td class="product-subtotal">
                                                <span class="amount"><fmt:formatNumber value="${item.value*item.key.donGia}"/></span> 
                                            </td>
                                            </form>
                                        </tr>
                                        </c:forEach>
                                    
                                        <tr>
                                            <td class="actions" colspan="7">
                                                <div class="coupon">
                                                    <label for="coupon_code">Phiếu thưởng:</label>
                                                    <input type="text" placeholder="Mã phiếu" value="" id="coupon_code" class="input-text" name="coupon_code">
                                                    <input type="submit" value="Áp dụng" name="apply_coupon" class="button">
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            

                            <div class="cart-collaterals">

                            <div class="cart_totals ">
                                <h2>Tổng giỏ hàng</h2>

                                <table cellspacing="0">
                                    <tbody>
                                        <tr class="cart-subtotal">
                                            <th>Cộng thành tiền</th>
                                            <td><span class="amount"><fmt:formatNumber value="${cart.tongTien}"/> đ</span></td>
                                        </tr>

                                        <tr class="shipping">
                                            <th>Phí giao hàng</th>
                                            <td>Miễn phí</td>
                                        </tr>

                                        <tr class="order-total">
                                            <th>Tổng cộng</th>
                                            <td><strong><span class="amount"><fmt:formatNumber value="${cart.tongTien}"/></span></strong> </td>
                                        </tr>
                                        <tr>
                                        <td colspan="2"><a href="trang-thanh-toan.jsp">THANH TOÁN</a></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            </div>
                        </div>                        
                    </div>                    
                </div>
            </div>
        </div>
        
    </div>