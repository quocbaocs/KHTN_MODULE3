package javaBeans;

/*
 * Java bean là lớp đơn giản thỏa 4 yêu cầu
 * 1. thực thi giao tiếp Serializable
 * 2. Thành phần dữ liêu private 
 * 3. có các hàm getter & setter
 * 4. có phương thức khởi tạo không tham số
 * 
 */
public class LoaiSua implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private String maLoai;
	private String tenLoai;

	public LoaiSua() {
		super();
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

}
