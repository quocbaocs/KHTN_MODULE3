package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataTransferObject.HangSua;

public class HangSuaDAO implements DAO<HangSua> {
	private Connection conn;

	@Override
	public HangSua get(String ma) {
		String sql = "select * from hang_sua where ma_hang_sua='" + ma + "'";
		conn = CSDL.getKetNoi();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				HangSua hs = new HangSua();
				hs.setMaHangSua(rs.getString("ma_hang_sua"));
				hs.setTenHangSua(rs.getString("ten_hang_sua"));
				hs.setDiaChi(rs.getString("dia_chi"));
				hs.setDienThoai(rs.getString("dien_thoai"));
				hs.setEmail(rs.getString("email"));
				return hs;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean insert(HangSua t) {
		
		return false;
	}

	@Override
	public void delete(String ma) {

	}

	@Override
	public List<HangSua> list() {
		List<HangSua> list = null ;
		String sql = "select * from hang_sua";
		conn = CSDL.getKetNoi();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			list = new ArrayList<HangSua>();
			while (rs.next()) {
				HangSua hs = new HangSua();
				hs.setMaHangSua(rs.getString("ma_hang_sua"));
				hs.setTenHangSua(rs.getString("ten_hang_sua"));
				hs.setDiaChi(rs.getString("dia_chi"));
				hs.setDienThoai(rs.getString("dien_thoai"));
				hs.setEmail(rs.getString("email"));
				list.add(hs);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
		

	}

	@Override
	public boolean update(String ma) {
		return false;
	}

}
