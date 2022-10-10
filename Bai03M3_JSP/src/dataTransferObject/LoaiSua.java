package dataTransferObject;

public class LoaiSua {
	
	private String maLoaiSua;
	private String tenLoaiSua;

	public LoaiSua(String maLoaiSua, String tenLoaiSua) {
		super();
		this.maLoaiSua = maLoaiSua;
		this.tenLoaiSua = tenLoaiSua;
	}

	public LoaiSua() {
		super();
	}

	public String getMaLoaiSua() {
		return maLoaiSua;
	}

	public void setMaLoaiSua(String maLoaiSua) {
		this.maLoaiSua = maLoaiSua;
	}

	public String getTenLoaiSua() {
		return tenLoaiSua;
	}

	public void setTenLoaiSua(String tenLoaiSua) {
		this.tenLoaiSua = tenLoaiSua;
	}

}
