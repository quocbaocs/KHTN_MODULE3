## Hibernate 
	- Mô hình đối tượng quan hệ, mỗi bảng có quan hệ với nhau 
	- Hiện thực chuẩn JPA
	- Giúp tạo ra những mô hình
	- Lưu trữ tự động
	- Làm việc trên đối tượng, không làm việc với bảng trong csdl bên dưới.
	- Đặc biệt là có truy vấn HQL
		+ SQL thực hiện truy vấn trên bảng.
		+ Hibernate thực hiện truy vấn trên đối tượng persistence liên quan tới cái phiên.

### Các bước viết ứng dụng sử dụng hibernate
	-Trong mối quan hệ 1-n phải join
	- Truy vấn trên thực thể: 
	+Ex:
		select s.tenSua,s.hangSua.tenHangSua, 	s.loaiSua.tenLoai, 		ct.hoaDon.soHoaDon, 	ct.hoaDon.khachHang.tenKhachHang,
		ct.soLuong, ct.donGia from Sua s join s.ctHoadons 	ct 		where s.tenSua like '%Mama%'
		
	- Hướng dẫn join nhiều bảng trong java sử dung hibernate 
		+ String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua";
	- Truy vấn lồng cấp