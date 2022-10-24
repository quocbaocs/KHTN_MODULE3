<%-- 
    Document   : cua-hang
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2>Shop</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
            
                 <c:forEach var="sp" items="${dssp}">
                
                <div class="col-md-3 col-sm-6">
                    <div class="single-shop-product">
                        <div class="product-upper">
                            <img src="img/${sp.hinhAnh}" alt="" style="width: 195px; height: 243px"/>
                        </div>
                        <p><a href="trang-san-pham.jsp?id=${sp.id}">${sp.tenSanPham}</a></p>
                        <div class="product-carousel-price">
                            <ins><fmt:formatNumber value="${sp.donGia}"/> vnđ</ins> <del><fmt:formatNumber value="${sp.donGiaKM}"/> vnđ</del>
                        </div>  
                        
                        <div class="product-option-shop">
                            <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" href="trang-gio-hang.jsp?id=${sp.id}">Add to cart</a>
                        </div>                       
                    </div>
                </div>
                 </c:forEach>
                
            </div>
            
            <div class="row">
                <div class="col-md-12">
                    <div class="product-pagination text-center">
                        <nav>
                          <ul class="pagination">
                            <li>
                              <a href="?page=1" aria-label="Previous">
                                <span aria-hidden="true">&lt;&lt;</span>
                              </a>
                              <a href="?page=${param.page-1<1?1:param.page-1 }" aria-label="Previous">
                                <span aria-hidden="true">&lt;</span>
                              </a>
                            </li>
                            <c:forEach begin="1" end="${tongSoTrang}" var="i">
                            <li><a href="?page=${i}">${i}</a></li>
                            </c:forEach>
                            <li>
                             <a href="?page=${param.page+1>tongSoTrang?tongSoTrang:param.page+1 }" aria-label="Previous">
                                <span aria-hidden="true">&gt;</span>
                              </a>
                              <a href="?page=${tongSoTrang}" aria-label="Previous">
                                <span aria-hidden="true">&gt;&gt;</span>
                              </a>
                            </li>
                          </ul>
                        </nav>                        
                    </div>
                </div>
            </div>
        </div>
    </div>
