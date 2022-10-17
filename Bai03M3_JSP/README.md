## Các JSP tags dùng trong trang JSP
	1. <%@ khai báo lớp, tập tin , thư viện%>
	2. <%! khai báo biến, hàm dùng chung%>
	3. <% các lệnh Java%>
	4. <%= biểu thức in ra %>
	5. <jsp: actionName(các hành động được đặt tên)
	6. <%-- ghi chú trong JSP--%>
	
## Liệt kê danh sách loại sữa

	1. dùng một trang jsp + jsp tag				(chạy trên jsp)
	2. cách 1 + java bean + business logic	(chạy trên jsp)
	3. cách 2 + servlet							(chạy trên servlet)
	4. Cách 3 + EL + JSTL							(chạy trên servlet)
	
##	MVC
	+ Dữ liệu	(model)
	+ Hiển thị (view)
	+ Điều khiển (Controller): thành phần trung gian ánh sạ giữa view và model (chuẩn bị dữ liệu và chọn view để hiển thị lên)
	- Một cái tồn tại lâu dài được gọi là persistence

	* Ưu điểm
	-Tách nhỏ giảm được được độ phức tạp code
	-Tính tái sử dụng
	...
	* Nhược điểm:
	+	Đối với dự án nhỏ gây cồng kềnh, 
	+	Tốn thời gian phát triển, phải chia vai trò,
	+	Tốn thời gian trung chuyển
	
	
## Bài tập 9 MVC
	Model 
		1. Java bean (chứa và truyền dữ liệu)
			LoaiSua, HangSua, Sua
		2. Business logic
			LoaiSuaBL -> docTatCa() -> List<LoaiSua>
			HangSuaBL -> docTatCa() -> List<HangSua>
						-> docTheoMaHang(String maHang) -> HangSua
			SuaBL -> docTheoHangLoaiTen(String maHang, String maLoai, String tenSua) -> List<Sua>

	View 
		3, JSP: Tạo trang JSP sử dụng html, jsp tags, EL, JSTL
	
	Controller
		4. Servlet:
			- Chuẩn bị dữ liệu , tạo ra danh sách loại sữa, danh sách hãng sữa
			List<HangSua>
			List<LoaiSua>
			HangSua
			List<Sua>