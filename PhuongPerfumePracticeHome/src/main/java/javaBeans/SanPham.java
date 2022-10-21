package javaBeans;

import java.util.Date;

public class SanPham {
	private int id;
	private String tenSanPham;
	private String moTa;
	private String hinhAnh;
	private double donGia;
	private double donGiaKM;
	private int soLuong;
	private Date ngayTao;
	private int hienThi;
	private int idLoai;
	private int idThuongHieu;

	public SanPham(int id, String tenSanPham, String moTa, String hinhAnh, double donGia, double donGiaKM, int soLuong,
			Date ngayTao, int hienThi, int idLoai, int idThuongHieu) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.donGia = donGia;
		this.donGiaKM = donGiaKM;
		this.soLuong = soLuong;
		this.ngayTao = ngayTao;
		this.hienThi = hienThi;
		this.idLoai = idLoai;
		this.idThuongHieu = idThuongHieu;
	}

	public SanPham() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getDonGiaKM() {
		return donGiaKM;
	}

	public void setDonGiaKM(double donGiaKM) {
		this.donGiaKM = donGiaKM;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public int getHienThi() {
		return hienThi;
	}

	public void setHienThi(int hienThi) {
		this.hienThi = hienThi;
	}

	public int getIdLoai() {
		return idLoai;
	}

	public void setIdLoai(int idLoai) {
		this.idLoai = idLoai;
	}

	public int getIdThuongHieu() {
		return idThuongHieu;
	}

	public void setIdThuongHieu(int idThuongHieu) {
		this.idThuongHieu = idThuongHieu;
	}

	@Override
	public String toString() {
		return "SanPham [id=" + id + ", tenSanPham=" + tenSanPham + ", moTa=" + moTa + ", hinhAnh=" + hinhAnh
				+ ", donGia=" + donGia + ", donGiaKM=" + donGiaKM + ", soLuong=" + soLuong + ", ngayTao=" + ngayTao
				+ ", hienThi=" + hienThi + ", idLoai=" + idLoai + ", idThuongHieu=" + idThuongHieu + "]";
	}
	
	

}
