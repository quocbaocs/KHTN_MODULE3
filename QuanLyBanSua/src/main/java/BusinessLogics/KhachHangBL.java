package BusinessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.KhachHang;

public class KhachHangBL {

	public static int tongSoTrang(int soDongTrang) {
		int tongSoDong, tongSoTrang;
		String sql = "select * from khach_hang";
		List<KhachHang> dskh = taoDanhSach(sql);

		tongSoDong = dskh.size();
		tongSoTrang = tongSoDong / soDongTrang + (tongSoDong % soDongTrang == 0 ? 0 : 1);
		return tongSoTrang;
	}

	private static List<KhachHang> taoDanhSach(String sql) {
		List<KhachHang> dsKH = null;
		try (Connection con = CSDL.getKetNoi()) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			dsKH = new ArrayList<>();
			while (rs.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKhachHang(rs.getString("ma_khach_hang"));
				kh.setTenKhachHang(rs.getString("ten_khach_hang"));
				kh.setPhai(rs.getBoolean("phai"));
				kh.setDiaChi(rs.getString("dia_chi"));
				kh.setDienThoai(rs.getString("dien_thoai"));
				kh.setEmail(rs.getString("email"));
				dsKH.add(kh);

			}
		} catch (Exception e) {
			throw new RuntimeException("Bị lỗi: " + e.getMessage());
		}
		return dsKH;
	}

	public static List<KhachHang> khachHangTrang(int trang, int soDongTrang) {
		int viTriDau = (trang == 1 ? 0 : (trang - 1) * soDongTrang);
		String sql = "select * from khach_hang limit " + viTriDau + "," + soDongTrang;
		List<KhachHang> dskh = taoDanhSach(sql);
		return dskh;
	}

	public static boolean xoaKhachHangID(String maKhachHang) {
		String sql = "DELETE FROM khach_hang WHERE ma_khach_hang='" + maKhachHang + "'";
		Connection kn = CSDL.getKetNoi();
		boolean check = false;
		try {
			Statement stm = kn.createStatement();
			int rs = stm.executeUpdate(sql);
			if (rs > 0) {
				check = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return check;
	}

	public static boolean updateKhachHangID(KhachHang kh) {
		String sql = "update khach_hang set ten_khach_hang=?,phai=?, dia_chi=?, dien_thoai=?, email=? where ma_khach_hang=?";
		Connection kn = CSDL.getKetNoi();
		boolean check = false;
		try {
			PreparedStatement prstm = kn.prepareStatement(sql);
			prstm.setString(1,kh.getTenKhachHang());
			prstm.setBoolean(2,kh.isPhai());
			prstm.setString(3,kh.getDiaChi());
			prstm.setString(4,kh.getDienThoai());
			prstm.setString(5,kh.getEmail());
			prstm.setString(6,kh.getMaKhachHang());
			int rs = prstm.executeUpdate();
			if (rs > 0) {
				check = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return check;
		
	}

	public static KhachHang docKhachHangID(String makh) {
		KhachHang kh = null;
		String sql = "select * from khach_hang where ma_khach_hang='"+makh+"'";
		try (Connection con = CSDL.getKetNoi()) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			if (rs.next()) {
				 kh = new KhachHang();
				kh.setMaKhachHang(rs.getString("ma_khach_hang"));
				kh.setTenKhachHang(rs.getString("ten_khach_hang"));
				kh.setPhai(rs.getBoolean("phai"));
				kh.setDiaChi(rs.getString("dia_chi"));
				kh.setDienThoai(rs.getString("dien_thoai"));
				kh.setEmail(rs.getString("email"));
				return kh;
			}
		} catch (Exception e) {
			throw new RuntimeException("Bị lỗi: " + e.getMessage());
		}
		return kh;
	}

}
