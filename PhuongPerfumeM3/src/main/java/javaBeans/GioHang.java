package javaBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import businessLogics.SanPhamBL;

public class GioHang implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Hashtable<Integer, Integer> dsh; // key idsp, value: slm

	public GioHang() {
		dsh = new Hashtable<Integer, Integer>();
	}

	public void them(int idsp, int slm) {
		if (dsh.containsKey(idsp)) {
			dsh.replace(idsp, dsh.get(idsp) + slm);
		} else {
			dsh.put(idsp, slm);
		}
	}

	public int soMatHang() {
		return dsh.size();
	}
	
	public double tongTien() {
		double tt =0;
		for(int idsp: dsh.keySet()) {
			SanPham sp = SanPhamBL.docTheoID(idsp);
			tt += sp.getDonGia()*dsh.get(idsp);
		}
		return tt;
	}
	
	public List<SanPhamMua> danhSachSanPhamMua(){
		List<SanPhamMua> dsspm = new ArrayList<SanPhamMua>();
		for(int idsp: dsh.keySet()) {
			SanPham sp = SanPhamBL.docTheoID(idsp);
			SanPhamMua spm = new SanPhamMua();
			
			spm.setId(sp.getId());
			spm.setTenSanPham(sp.getTenSanPham());
			spm.setMoTa(sp.getMoTa());
			spm.setHinhAnh(sp.getHinhAnh());
			spm.setDonGia(sp.getDonGia());
			spm.setDonGiaKM(sp.getDonGiaKM());
			spm.setSoLuong(sp.getSoLuong());
			spm.setHienThi(sp.getHienThi());
			spm.setId_loai(sp.getId_loai());
			spm.setId_thuongHieu(sp.getId_thuongHieu());
			spm.setSoLuongMua(dsh.get(idsp));
			dsspm.add(spm);
		}
		return dsspm;
	}
	
	
//	public static void main(String[] args) {
//		GioHang gh = new GioHang();
//		gh.them(1,1);
//		gh.them(1,3);
//		gh.them(2,3);
//		System.out.println("So mat hang: "+gh.soMatHang());
//		System.out.println("Tong tien : "+gh.tongTien());
//	}
	
	public static void main(String[] args) {
		GioHang gh = new GioHang();
		gh.them(1, 2);
		gh.them(2, 3);
		List<SanPhamMua> list = gh.danhSachSanPhamMua();
		list.forEach(spm->{
			System.out.println(spm.getId() + " -"+spm.getTenSanPham() + " - " +spm.getSoLuongMua()+ " - " +spm.thanhTien());
		});
	}
	
	

}
