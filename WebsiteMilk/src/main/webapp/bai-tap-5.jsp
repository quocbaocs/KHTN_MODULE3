<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="businessLogics.CSDL"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%!String sql = "select s.ten_sua, h.ten_hang_sua, l.ten_loai, s.trong_luong, s.don_gia, s.hinh from sua AS s INNER JOIN hang_sua AS h ON s.Ma_hang_sua = h.Ma_hang_sua INNER JOIN loai_sua AS l ON s.Ma_loai_sua = l.Ma_loai_sua";
	Connection kn = CSDL.getKetNoi();

	Statement stm;
	ResultSet rs = null;
	Locale lc = new Locale("vi","VN");
	
	NumberFormat fn = NumberFormat.getNumberInstance();
	
	int soDongTrang = 5, tongSoTrang, trang = 1;
	
	
	%>
<%
if(rs==null){
stm = kn.createStatement();
rs = stm.executeQuery(sql);
rs.last();
int tsd = rs.getRow();
tongSoTrang = tsd/soDongTrang + (tsd%soDongTrang!=1?1:0);
}
if(request.getParameter("trang")!=null)
	trang = Integer.parseInt(request.getParameter("trang"));
int vt = (trang-1)*soDongTrang;
rs = stm.executeQuery(sql +" limit "+vt+","+soDongTrang);
int stt=vt+1;


%>
</head>
<body>
<table border="1" style="border-collapse: collapse; margin: auto;">
<caption>THÔNG TIN SỮA</caption>
			<tr style="text-align: center;">
				<th>Số STT</th>
				<th>Tên sữa</th>
				<th>Hãng sữa</th>
				<th>Loại sữa</th>
				<th>Trọng lượng</th>
				<th>Đơn giá</th>
			</tr>
			<%while(rs.next()){ %>
			<tr>
			<td><%=stt++ %></td>
			<td><%=rs.getString("ten_sua") %></td>
			<td><%=rs.getString("ten_hang_sua") %></td>
			<td><%=rs.getString("ten_loai") %></td>
			<td><%=rs.getInt("trong_luong") %></td>
			<td><%=rs.getInt("don_gia") %></td>
			</tr>
			
			<%} %>
</table>
<p align="center">
	<a href="bai-tap-5.jsp?trang=1">&lt;&lt;</a>
	<a href="bai-tap-5.jsp?trang=<%=trang-1<1?trang:trang-1%>">&lt;</a>
	<%for(int i=1; i <=tongSoTrang; i++){ %>
	<a href="bai-tap-5.jsp?trang=<%=i%>" style="color: <%=trang==i?"red":"black"%>"><%=i %></a>
	<%} %>
	<a href="bai-tap-5.jsp?trang=<%=trang+1>tongSoTrang?tongSoTrang:trang+1%>">&gt;</a>
	<a href="bai-tap-5.jsp?trang=<%=tongSoTrang%>">&gt;&gt;</a>
</p>
</body>
</html>