# Xây dựng phần Quảng cáo theo mô hình MVC

	- Model :
		1. Java bean : QuangCao
		2. Business logic : QuangCaoBL
	- View:
		3. Sửa lại trang View/quang-cao.jsp với dữ liệu động
	
	- Controller:
		4.Servlet
			List<QuangCao>
			Trang Views/quang-cao.jsp  ->include ***
	-> Sửa lịa trang-chu.jsp thay Views/quang-cao.jsp bằng QuangCaoServlet
	-> Sửa lại cấu hình workspace: Window/Preferences/Web/JSP/validation
	+ Included fragment file not found: Warning
	+ Included fragment file not specified: Warning

# Xây dựng phần Thương hiệu theo mô hình MVC

	- Model :
		1. Java bean : ThuongHieu
		2. Business logic : ThuongHieuBL
	- View:
		3. Sửa lại trang View/thuong-hieu.jsp với dữ liệu động
	
	- Controller:
		4.Servlet
			List<ThuongHieu>
			Trang Views/thuong-hieu.jsp ->include ***
	-> Sửa lịa trang-chu.jsp thay Views/thuong-hieu.jsp bằng ThuongHieuServlet
	-> Sửa lại cấu hình workspace: Window/Preferences/Web/JSP/validation
	+ Included fragment file not found: Warning
	+ Included fragment file not specified: Warning
	
# Xây dựng phần Đăng nhập theo mô hình MVC

	- Model :
		1. Java bean : NguoiDung
		2. Business logic : NguoiDungBL
			docTheoEmailPassword() ->NguoiDung
	- View:
		3. Tạo form đăng nhập trong View/cuoi-trang.jsp
	
	- Controller:
		4.Servlet(DangNhapServlet)
			- Lấy thông tin Email, pasword
			- Tìm ra NguòiDung
			-Đặt NguoiDung lên session
			- Hiển thị họ tên ở Views/dau-trang.jsp
			-Trả về trang chur
	-> Sửa lịa trang-chu.jsp thay Views/thuong-hieu.jsp bằng ThuongHieuServlet
	-> Sửa lại cấu hình workspace: Window/Preferences/Web/JSP/validation
	+ Included fragment file not found: Warning
	+ Included fragment file not specified: Warning

# Xây dựng phần Sản phẩm theo mô hình MVC

	- Model :
		1. Java bean : SanPham
		2. Business logic : SanPhamBL
			sanPhamMoi(int top) -> List<SanPham>
	- View:
		3. Sửa lại trang View/san-pham-moi.jsp với dữ liệu động
	
	- Controller:
		4.Servlet(DangNhapServlet)
			- Lấy thông tin Email, pasword
			- Tìm ra NguòiDung
			-Đặt NguoiDung lên session
			- Hiển thị họ tên ở Views/dau-trang.jsp
			-Trả về trang chủ
	-> Sửa lịa trang-chu.jsp thay Views/san-pham-moi.jsp bằng SanPhamMoiServlet
	-> Sửa lại cấu hình workspace: Window/Preferences/Web/JSP/validation
	+ Included fragment file not found: Warning
	+ Included fragment file not specified: Warning


# Session, Cookie, filter
	- Session: thong tin dang nhap, thong tin mua hang,đối tượng giúp server lưu trữ trạng thái giao tiếp của client
	Hết phiên trong 3 trường hợp:
		+ Dùng lênh xóa phiên 
		+ Đóng trình duyệt
		+ Hết thời gian trình duyệt cấu hình
		Trong trang jsp có đối tượng session, trong servlet thì có HttpSession
		Một số phương thức khác để lưu trữ là : Hidden Field hoặc Cookie
	- Cookie: 
		