package BusinessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.HangSua;

public class HangSuaBL {
	public static List<HangSua> docTatCa(){
		List<HangSua> dsls = new ArrayList<HangSua>();
		try (Connection ketNoi = CSDL.getKetNoi()){
			Statement stm = ketNoi.createStatement();
			ResultSet rs = stm.executeQuery("select * from hang_sua");
			while(rs.next()) {
				HangSua hs = new HangSua();
				hs.setMaHang(rs.getString("ma_hang_sua"));
				hs.setTenHang(rs.getString("ten_hang_sua"));
				hs.setDiaChi(rs.getString("dia_chi"));
				hs.setDienThoai(rs.getString("dien_thoai"));
				hs.setEmail(rs.getString("email"));
				dsls.add(hs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsls;
	}
	public static int them(HangSua hs) {
		String sql = "insert into hang_sua(ma_hang_sua, ten_hang_sua, dia_chi, dien_thoai, email) values (?,?,?,?,?)";
		try (Connection ketNoi = CSDL.getKetNoi()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1, hs.getMaHang());
			pst.setString(2, hs.getTenHang());
			pst.setString(3, hs.getDiaChi());
			pst.setString(4, hs.getDienThoai());
			pst.setString(5, hs.getEmail());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static HangSua docTheoMaHang(String maHang) {
		HangSua hs = null;
		String sql = "select * from hang_sua where ma_hang_sua=?";
		try (Connection ketNoi = CSDL.getKetNoi()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1,maHang);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				hs = new HangSua();
				hs.setMaHang(rs.getString("ma_hang_sua"));
				hs.setTenHang(rs.getString("ten_hang_sua"));
				hs.setDiaChi(rs.getString("dia_chi"));
				hs.setDienThoai(rs.getString("dien_thoai"));
				hs.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hs;
	}
	public static int sua(HangSua hs) {
		String sql = "update hang_sua set ten_hang_sua = ?, dia_chi=?, dien_thoai=?, email=? where ma_hang_sua=?";
		try (Connection ketNoi = CSDL.getKetNoi()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1,hs.getTenHang());
			pst.setString(2, hs.getDiaChi());
			pst.setString(3, hs.getDienThoai());
			pst.setString(4, hs.getEmail());
			pst.setString(5,hs.getMaHang());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static int xoa(String maHang) {
		String sql = "delete from hang_sua where ma_hang_sua=?";
		try (Connection ketNoi = CSDL.getKetNoi()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1,maHang);
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

//	public static void main(String[] args) {
//		HangSuaBL hbl = new HangSuaBL();
//		List<HangSua> list = hbl.docTatCa();
//		list.forEach(s->System.out.println(s.toString()));
//		
//	}
	

}
