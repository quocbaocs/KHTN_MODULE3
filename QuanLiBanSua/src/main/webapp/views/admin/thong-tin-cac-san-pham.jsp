<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="me"%>
<me:template-admin title="Danh sach san pham">
	<jsp:attribute name="content">
		 <div class="list-product">
		 	<c:forEach items="${dssp}" var="sp">
                <div class="item">
                	<h4><a href="san-pham?maSua=${sp.maSua}" style="color: red;">${sp.tenSua}</a></h4>
                	<p>${sp.trongLuong} gr - ${sp.donGia} VNĐ</p>
                	<img src="${pageContext.request.contextPath }/images/products/${sp.hinh}">

                </div> 
              </c:forEach>


            </div>
	</jsp:attribute>
</me:template-admin>