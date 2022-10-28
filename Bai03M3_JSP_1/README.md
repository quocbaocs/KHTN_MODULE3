http://www.cs.tlu.ee/~jaagup/kool/java/abiinfo/javaeetutorial5/examples/web/bookstore3/web/template/
https://docs.oracle.com/cd/E19316-01/819-3669/bnaoh/index.html

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
	
## Template
	Mục đích sử dụng lại
	Thuộc tính là một cái chuỗi, thuộc tính thứ hai là fgragment
	
	- Tag Library Descriptor
	
	B1: Tạo folder tags
	B2: Tạo file có phần mở rộng là tag(chọn file jsp nhưng phần mở rộng là tag)
		- import <%@ tag language="java" pageEncoding="UTF-8"%> 
	B3: Khai báo thuộc tính tên, kiểu trong file .tag
	B4: Tạo ra một trang jsp , bỏ nọi dung trong trang jsp, sau đó chèn <%@taglib tagdir="/WEB-INF/tags" prefix="m"%>
		