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
	
	-Truy vấn sữa bán chạy
			+ select s.*, sum(ct.so_Luong) as tsl from sua s inner join ct_hoadon ct on s.Ma_Sua = ct.ma_Sua group BY 1 order by sum(ct.So_luong) desc limit 0,5
		
	- truy vấn trên đối tượng - > trả về một danh sách đối tượng
			+ select s, sum(ct.soLuong) as tsl from Sua s join s.ctHoadons ct group by s order by tsl desc 

### Ghi chú
		- Câu lệnh select sai không ảnh hưởng đén dữ liệu
		- Truyền vào đối tượng, câu truy vấn thêm sửa xóa , luôn đọc trong transaction  ,nếu đúng thì commit,  nếu có sai thì nó sẽ rollback lại
		
	