<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật loại sữa</title>
    </head>
    <body>
        <form name="frmLoaiSua" action="CapNhatLoaiSuaServlet" method="post">
            <table border="0">
                <caption>CẬP NHẬT LOẠI SỮA</caption>
                <tbody>
                    <tr>
                        <td>Mã loại</td>
                        <td><input type="text" name="txtMaLoai" value="${loaiSua.maLoaiSua}" /></td>
                    </tr>
                    <tr>
                        <td>Tên loại</td>
                        <td><input type="text" name="txtTenLoai" value="${loaiSua.tenLoai}" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                        	<button value="them" name="btnChon">Thêm</button>
                        	<button value="tim" name="btnChon">Tìm</button>
                        	<button value="sua" name="btnChon">Sửa</button>
                        	<button value="xoa" name="btnChon">Xóa</button>
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
        <table border="1">
            <caption>DANH SÁCH LOẠI SỮA</caption>
            <thead>
                <tr>
                    <th>Mã loại</th>
                    <th>Tên loại</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${dsls}" var="ls">
                    <tr>
                        <td>${ls.maLoaiSua}</td>
                        <td>${ls.tenLoai}</td>
                    </tr>
            </c:forEach>
            </tbody>
        </table>

    </body>
</html>
    