# Java Bean
	Java bean là lớp đơn giản thỏa 4 yêu cầu
	1. thực thi giao tiếp Serializable
	2. Thành phần dữ liêu private 
	3. có các hàm getter & setter
	4. có phương thức khởi tạo không tham số

	
# Phân trang
	1. Xác định số dòng của mỗi trang(vd= sdmt=5)
	2. Tính được tổng số trang
			- lấy tống số dòng (tsd = 43)
			-> tính ra số trang (tst)
			tst = tsd/sdmt + (tsd%sdmt!=0?1:0);
						8		+	1 = 9
	3. Lấy trang chọn xem 
			-> Lấy ra được số dòng của trang đó
	
	sql: select * from sua limit vitri,sdmt(sodonglay);	
	
	trang=1 : vitri=0->4; 	-> limit(trang-1)*sdmt,sdmt
	trang=2 : vitri=5->9; 	-> limit(trang-1)*sdmt,sdmt
	trang=3 : vitri=10->14; -> limit(trang-1)*sdmt,sdmt
	