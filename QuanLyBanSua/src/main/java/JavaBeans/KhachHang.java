package JavaBeans;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private boolean phai;
	private String diaChi;
	private String dienThoai;
	private String email;

	public KhachHang() {
		super();
	}

	public KhachHang(String maKhachHang, String tenKhachHang, boolean phai, String diaChi, String dienThoai,
			String email) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.phai = phai;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public boolean isPhai() {
		return phai;
	}

	public void setPhai(boolean phai) {
		this.phai = phai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", phai=" + phai
				+ ", diaChi=" + diaChi + ", dienThoai=" + dienThoai + ", email=" + email + "]";
	}

	
}
