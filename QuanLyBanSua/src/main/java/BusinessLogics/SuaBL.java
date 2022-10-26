
package BusinessLogics;

import JavaBeans.Sua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SuaBL {
public static List<Sua> docTatCa() {
		List<Sua> dsSua = null;
		try (Connection con = CSDL.getKetNoi()) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from sua");
			dsSua = new ArrayList<>();
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaLoai(rs.getString("ma_loai_sua"));
				s.setMaHang(rs.getString("ma_hang_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("loi_ich"));
				s.setHinh(rs.getString("hinh"));
				dsSua.add(s);
			}
		} catch (Exception e) {
			throw new RuntimeException("Bị lỗi: " + e.getMessage());
		}
		return dsSua;
	}

	public static Sua docTheoMaSua(String ma) {
		Connection con = CSDL.getKetNoi();
		String sql = "SELECT * FROM SUA WHERE MA_SUA='" + ma + "'";
		Statement stm;
		Sua sua = null;
		try {
			
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				sua = new Sua();
				sua.setMaSua(ma);
				sua.setTenSua(rs.getString("ten_sua"));
				sua.setMaLoai(rs.getString("ma_loai_sua"));
				sua.setMaHang(rs.getString("ma_hang_sua"));
				sua.setTrongLuong(rs.getInt("trong_luong"));
				sua.setDonGia(rs.getInt("don_gia"));
				sua.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				sua.setLoiIch(rs.getString("loi_ich"));
				sua.setHinh(rs.getString("hinh"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return sua;

	}

	public static int tongSoTrang(int soDongTrang) {
		int tongSoDong, tongSoTrang;
		String sql = "select * from sua";
		List<Sua> dssp = taoDanhSach(sql);

		tongSoDong = dssp.size();
		tongSoTrang = tongSoDong / soDongTrang + (tongSoDong % soDongTrang == 0 ? 0 : 1);
		return tongSoTrang;
	}

	private static List<Sua> taoDanhSach(String sql) {
		List<Sua> dsSua = null;
		try (Connection con = CSDL.getKetNoi()) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			dsSua = new ArrayList<>();
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaLoai(rs.getString("ma_loai_sua"));
				s.setMaHang(rs.getString("ma_hang_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("loi_ich"));
				s.setHinh(rs.getString("hinh"));
				dsSua.add(s);
			}
		} catch (Exception e) {
			throw new RuntimeException("Bị lỗi: " + e.getMessage());
		}
		return dsSua;
	}

	public static List<Sua> sanPhamTrang(int trang, int soDongTrang) {
		int viTriDau = (trang == 1 ? 0 : (trang - 1) * soDongTrang);
		String sql = "select * from sua limit " + viTriDau + "," + soDongTrang;
		List<Sua> dssp = taoDanhSach(sql);
		return dssp;
	}

	public static List<Sua> timTheoTen(String tenSua) {
		List<Sua> dsSua = null;
		try (Connection con = CSDL.getKetNoi()) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from sua where ten_sua like '%" + tenSua + "%'");
			dsSua = new ArrayList<>();
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaLoai(rs.getString("ma_loai_sua"));
				s.setMaHang(rs.getString("ma_hang_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("loi_ich"));
				s.setHinh(rs.getString("hinh"));
				dsSua.add(s);
			}
		} catch (Exception e) {
			throw new RuntimeException("Bị lỗi: " + e.getMessage());
		}
		return dsSua;
	}

	public static List<Sua> timTheoLoaiHangTen(String maLoai, String maHang, String tenSua) {
		List<Sua> dsSua = null;
		try (Connection con = CSDL.getKetNoi()) {
			PreparedStatement pst = con
					.prepareStatement("select * from sua where ma_loai_sua = ? and ma_hang_sua=? and ten_sua like ?");
			pst.setString(1, maLoai);
			pst.setString(2, maHang);
			pst.setString(3, "%" + tenSua + "%");
			ResultSet rs = pst.executeQuery();
			dsSua = new ArrayList<>();
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaLoai(rs.getString("ma_loai_sua"));
				s.setMaHang(rs.getString("ma_hang_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("loi_ich"));
				s.setHinh(rs.getString("hinh"));
				dsSua.add(s);
			}
		} catch (Exception e) {
			throw new RuntimeException("Bị lỗi: " + e.getMessage());
		}
		return dsSua;
	}

	public static int themSua(Sua s) {
		String sql = "insert into sua(ma_sua,ten_sua,ma_loai_sua,ma_hang_sua,trong_luong,don_gia,tp_dinh_duong,loi_ich,hinh) values (?,?,?,?,?,?,?,?,?)";
		int smt = 0;
		try (Connection kn = CSDL.getKetNoi()) {
			PreparedStatement pst = kn.prepareStatement(sql);
			pst.setString(1, s.getMaSua());
			pst.setString(2, s.getTenSua());
			pst.setString(3, s.getMaLoai());
			pst.setString(4, s.getMaHang());
			pst.setInt(5, s.getTrongLuong());
			pst.setInt(6, s.getDonGia());
			pst.setString(7, s.getTpDinhDuong());
			pst.setString(8, s.getLoiIch());
			pst.setString(9, s.getHinh());
			smt = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return smt;
	}
//    public static void main(String[] args) {
//		Sua s = new Sua();
//		s.setMaSua("aa");
//		s.setTenSua("Sua aa");
//		s.setMaLoai("SB");
//		s.setMaHang("AB");
//		s.setTrongLuong(100);
//		s.setDonGia(500);
//		s.setTpDinhDuong("DHA");
//		s.setLoiIch("Bo nao");
//		s.setHinh("aa.jpg");
//		int smt = themSua(s);
//		if(smt>0)
//			System.out.println("Da them sua moi");
//		else
//			System.out.println("Khong them duoc sua moi");
//	}

	public static List<Sua> docTheoMaHang(String maHang) {
		List<Sua> dsSua = null;
		try (Connection con = CSDL.getKetNoi()) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from sua where ma_hang_sua='"+maHang+"'");
			dsSua = new ArrayList<>();
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaLoai(rs.getString("ma_loai_sua"));
				s.setMaHang(rs.getString("ma_hang_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("loi_ich"));
				s.setHinh(rs.getString("hinh"));
				dsSua.add(s);
			}
		} catch (Exception e) {
			throw new RuntimeException("Bị lỗi: " + e.getMessage());
		}
		return dsSua;
		
	}
	public static List<Sua> docTheoMaLoai(String maLoai) {
		List<Sua> dsSua = null;
		try (Connection con = CSDL.getKetNoi()) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from sua where ma_loai_sua='"+maLoai+"'");
			dsSua = new ArrayList<>();
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaLoai(rs.getString("ma_loai_sua"));
				s.setMaHang(rs.getString("ma_hang_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("loi_ich"));
				s.setHinh(rs.getString("hinh"));
				dsSua.add(s);
			}
		} catch (Exception e) {
			throw new RuntimeException("Bị lỗi: " + e.getMessage());
		}
		return dsSua;
		
	}
}
