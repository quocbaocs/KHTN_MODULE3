
package JavaBeans;

import java.io.Serializable;

public class Sua implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maSua;
    private String tenSua;
    private String maLoai;
    private String maHang;
    private int trongLuong;
    private int donGia;
    private String tpDinhDuong;
    private String loiIch;
    private String hinh;
    

    public Sua(String maSua, String tenSua, String maLoai, String maHang, int trongLuong, int donGia,
			String tpDinhDuong, String loiIch, String hinh) {
		super();
		this.maSua = maSua;
		this.tenSua = tenSua;
		this.maLoai = maLoai;
		this.maHang = maHang;
		this.trongLuong = trongLuong;
		this.donGia = donGia;
		this.tpDinhDuong = tpDinhDuong;
		this.loiIch = loiIch;
		this.hinh = hinh;
	}

	public String getMaSua() {
        return maSua;
    }

    public void setMaSua(String maSua) {
        this.maSua = maSua;
    }

    public String getTenSua() {
        return tenSua;
    }

    public void setTenSua(String tenSua) {
        this.tenSua = tenSua;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public int getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(int trongLuong) {
        this.trongLuong = trongLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getTpDinhDuong() {
        return tpDinhDuong;
    }

    public void setTpDinhDuong(String tpDinhDuong) {
        this.tpDinhDuong = tpDinhDuong;
    }

    public String getLoiIch() {
        return loiIch;
    }

    public void setLoiIch(String loiIch) {
        this.loiIch = loiIch;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public Sua() {
    }
    
}
