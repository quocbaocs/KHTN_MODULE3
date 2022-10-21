<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
   			table{
   			margin: auto;
   			}
        </style>
    </head>
    <body>
        <form name="frmTimSua" action="TimSuaTheoLoaiHangTenServlet" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th colspan="2">TÌM SỮA</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            Loại sữa:
                            <select name="cboLoai">
                                <c:forEach items="${dsls}" var="ls">
                                    <option value="${ls.maLoai}" ${param.cboLoai==null?"":(param.cboLoai eq ls.maLoai?"selected":"")}>${ls.tenLoai}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            Hãng sữa:
                            <select name="cboHang">
                                <c:forEach items="${dshs}" var="hs">
                                    <option value="${hs.maHang}" ${param.cboHang==null?"":(param.cboHang eq hs.maHang?"selected":"")}>${hs.tenHang}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Tên sữa:<input type="text" name="txtTenSuaTim" value="" />
                        </td>
                        <td>
                            <input type="submit" value="Tìm kiếm" name="btnTimKiem" />
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
        <c:if test="${soSP>0}">
            <p>Có ${soSP} sản phẩm được tìm thấy</p>
            <table border="1">
                <tbody>
                <c:forEach items="${dsSua}" var="s">
                    <tr>
                        <td colspan="2">${s.tenSua}</td>
                    </tr>
                    <tr>
                        <td><img src="images/${s.hinh}"></td>
                        <td>
                        	<p><b>${hangSua.tenHang}</b></p>
                            <p><b>Thành phần dinh dưỡng</b><br>${s.tpDinhDuong}</p>
                            <p><b>Lợi ích</b><br>${s.loiIch} </p>
                            <p><b>Trọng lượng:</b> ${s.trongLuong} gr - <b>Đơn giá:</b> ${s.donGia} VNĐ </p>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        
    </body>
</html>
1