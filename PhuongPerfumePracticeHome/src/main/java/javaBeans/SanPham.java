package javaBeans;

import java.util.Date;
import java.util.Objects;

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
	private int id_loai;
	private int id_thuongHieu;

	public SanPham(int id, String tenSanPham, String moTa, String hinhAnh, double donGia, double donGiaKM, int soLuong,
			Date ngayTao, int hienThi, int id_loai, int id_thuongHieu) {
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
		this.id_loai = id_loai;
		this.id_thuongHieu = id_thuongHieu;
	}

	public SanPham() {
		super();
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

	public int getId_loai() {
		return id_loai;
	}

	public void setId_loai(int id_loai) {
		this.id_loai = id_loai;
	}

	public int getId_thuongHieu() {
		return id_thuongHieu;
	}

	public void setId_thuongHieu(int id_thuongHieu) {
		this.id_thuongHieu = id_thuongHieu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(donGia, donGiaKM, hienThi, hinhAnh, id, id_loai, id_thuongHieu, moTa, ngayTao, soLuong,
				tenSanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Double.doubleToLongBits(donGiaKM) == Double.doubleToLongBits(other.donGiaKM)
				&& hienThi == other.hienThi && Objects.equals(hinhAnh, other.hinhAnh) && id == other.id
				&& id_loai == other.id_loai && id_thuongHieu == other.id_thuongHieu && Objects.equals(moTa, other.moTa)
				&& Objects.equals(ngayTao, other.ngayTao) && soLuong == other.soLuong
				&& Objects.equals(tenSanPham, other.tenSanPham);
	}

	public double getTongTien(int quantity) {
		return quantity * donGia;
	}

	@Override
	public String toString() {
		return "SanPham [id=" + id + ", tenSanPham=" + tenSanPham + ", moTa=" + moTa + ", hinhAnh=" + hinhAnh
				+ ", donGia=" + donGia + ", donGiaKM=" + donGiaKM + ", soLuong=" + soLuong + ", ngayTao=" + ngayTao
				+ ", hienThi=" + hienThi + ", id_loai=" + id_loai + ", id_thuongHieu=" + id_thuongHieu + "]";
	}

}
