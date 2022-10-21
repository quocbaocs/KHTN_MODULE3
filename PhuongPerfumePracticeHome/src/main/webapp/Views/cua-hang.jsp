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
		<c:forEach var="sp" items="${listSPT}">
			<div class="col-md-3 col-sm-6">
                    <div class="single-shop-product">
                        <div class="product-upper">
                            <img src="img/${sp.hinhAnh}" alt="" style="height: 200px; width: 200px">
                        </div>
                        <p style="font-size: 10px;"><a href="">${sp.tenSanPham }</a></p>
                        <div class="product-carousel-price">
                            <ins><fmt:formatNumber value="${sp.donGia}"/> vnđ</ins> <del><fmt:formatNumber value="${sp.donGiaKM}"/> vnđ</del>
                        </div>  
                        
                        <div class="product-option-shop">
                            <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" href="/canvas/shop/?add-to-cart=70">Add to cart</a>
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
							<li><a href="?trang=1">&lt;&lt;</a></li>
							<li><a
								href="?trang=<c:out value="${param.trang-1<1?param.trang:param.trang-1}"/>">&lt;</a></li>
							<li><c:forEach begin="1" end="${tongSoTrang}" var="i">
									<a href="?trang=${i}">${i}</a>
								</c:forEach></li>
							<li>
							
							<a
								href="?trang=<c:out value="${pram.trang+1>=tongSoTrang?tongSoTrang:param.trang+1}"/>">&gt;</a></li>
							<li><a href="?trang=${tongSoTrang}">&gt;&gt;</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</div>
