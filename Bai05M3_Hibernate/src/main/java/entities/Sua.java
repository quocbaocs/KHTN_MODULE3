package entities;
// Generated Oct 28, 2022, 6:31:15 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Sua generated by hbm2java
 */
@Entity
@Table(name = "sua", catalog = "qlbansua")
public class Sua implements java.io.Serializable {

	private String maSua;
	private HangSua hangSua;
	private LoaiSua loaiSua;
	private String tenSua;
	private int trongLuong;
	private int donGia;
	private String tpDinhDuong;
	private String loiIch;
	private String hinh;
	private Set<CtHoadon> ctHoadons = new HashSet<CtHoadon>(0);

	public Sua() {
	}

	public Sua(String maSua, HangSua hangSua, LoaiSua loaiSua, String tenSua, int trongLuong, int donGia,
			String tpDinhDuong, String loiIch, String hinh) {
		this.maSua = maSua;
		this.hangSua = hangSua;
		this.loaiSua = loaiSua;
		this.tenSua = tenSua;
		this.trongLuong = trongLuong;
		this.donGia = donGia;
		this.tpDinhDuong = tpDinhDuong;
		this.loiIch = loiIch;
		this.hinh = hinh;
	}

	public Sua(String maSua, HangSua hangSua, LoaiSua loaiSua, String tenSua, int trongLuong, int donGia,
			String tpDinhDuong, String loiIch, String hinh, Set<CtHoadon> ctHoadons) {
		this.maSua = maSua;
		this.hangSua = hangSua;
		this.loaiSua = loaiSua;
		this.tenSua = tenSua;
		this.trongLuong = trongLuong;
		this.donGia = donGia;
		this.tpDinhDuong = tpDinhDuong;
		this.loiIch = loiIch;
		this.hinh = hinh;
		this.ctHoadons = ctHoadons;
	}

	@Id

	@Column(name = "Ma_sua", unique = true, nullable = false, length = 6)
	public String getMaSua() {
		return this.maSua;
	}

	public void setMaSua(String maSua) {
		this.maSua = maSua;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Ma_hang_sua", nullable = false)
	public HangSua getHangSua() {
		return this.hangSua;
	}

	public void setHangSua(HangSua hangSua) {
		this.hangSua = hangSua;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Ma_loai_sua", nullable = false)
	public LoaiSua getLoaiSua() {
		return this.loaiSua;
	}

	public void setLoaiSua(LoaiSua loaiSua) {
		this.loaiSua = loaiSua;
	}

	@Column(name = "Ten_sua", nullable = false, length = 100)
	public String getTenSua() {
		return this.tenSua;
	}

	public void setTenSua(String tenSua) {
		this.tenSua = tenSua;
	}

	@Column(name = "Trong_luong", nullable = false)
	public int getTrongLuong() {
		return this.trongLuong;
	}

	public void setTrongLuong(int trongLuong) {
		this.trongLuong = trongLuong;
	}

	@Column(name = "Don_gia", nullable = false)
	public int getDonGia() {
		return this.donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	@Column(name = "Tp_dinh_duong", nullable = false, length = 65535)
	public String getTpDinhDuong() {
		return this.tpDinhDuong;
	}

	public void setTpDinhDuong(String tpDinhDuong) {
		this.tpDinhDuong = tpDinhDuong;
	}

	@Column(name = "Loi_ich", nullable = false, length = 65535)
	public String getLoiIch() {
		return this.loiIch;
	}

	public void setLoiIch(String loiIch) {
		this.loiIch = loiIch;
	}

	@Column(name = "Hinh", nullable = false, length = 200)
	public String getHinh() {
		return this.hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sua")
	public Set<CtHoadon> getCtHoadons() {
		return this.ctHoadons;
	}

	public void setCtHoadons(Set<CtHoadon> ctHoadons) {
		this.ctHoadons = ctHoadons;
	}

}
