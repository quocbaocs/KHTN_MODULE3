<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="me" uri="/WEB-INF/template"%>
<%@taglib uri="/WEB-INF/form" prefix="frm"%>
<me:bg title="Use Template">
<jsp:attribute name="content">
<div class="page-header">
MODULE 3: LẬP TRÌNH WEB VỚI JAVA
</div>

<p>BÀI TẬP CHƯƠNG TRÌNH LẬP TRÌNH VIÊN CÔNG NGHỆ JAVA</p>
<jsp:include page="ListProductController"/>
<div style="height: 200px; width: 100%; text-align: center; " align="center">
<frm:pagination url="${pageContext.request.contextPath}/template.jsp?p=%s" size="8" />
</div>
</jsp:attribute>
</me:bg>