package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataTransferObject.LoaiSua;
import dataTransferObject.SanPham;

public class SanPhamDAO implements DAO<SanPham> {
	private Connection conn;
	private HangSuaDAO hangSuaDao;
	private LoaiSuaDAO loaiSuaDao;
	

	@Override
	public SanPham get(String ma) {
		hangSuaDao = new HangSuaDAO();
		loaiSuaDao = new LoaiSuaDAO();
		String sql = "select * from sua where ma_sua='"+ma+"'";
		
		Statement stmt = null;
		ResultSet rs = null;
		conn = CSDL.getKetNoi();

		try {
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(sql);
			if (rs.next()) {
				SanPham sp = new SanPham();
				sp.setMaSua(rs.getString("ma_sua"));
				sp.setTenSua(rs.getString("ten_sua"));
				sp.setHangSua(hangSuaDao.get(rs.getString("ma_hang_sua")));
				sp.setLoaiSua(loaiSuaDao.get(rs.getString("ma_loai_sua")));
				sp.setTrongLuong(rs.getInt("trong_luong"));
				sp.setDonGia(rs.getInt("don_gia"));
				sp.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				sp.setLoiIch(rs.getString("loi_ich"));
				sp.setHinh(rs.getString("hinh"));
				return sp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		return null;

	}

	@Override
	public boolean insert(SanPham t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(String ma) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SanPham> list() {
		List<SanPham> ds = null;
		hangSuaDao = new HangSuaDAO();
		loaiSuaDao = new LoaiSuaDAO();
		String sql = "select * from sua";

		conn = CSDL.getKetNoi();
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			ds = new ArrayList<SanPham>();
			while (rs.next()) {

				SanPham sp = new SanPham();
				sp.setMaSua(rs.getString("ma_sua"));
				sp.setTenSua(rs.getString("ten_sua"));
				sp.setHangSua(hangSuaDao.get(rs.getString("ma_hang_sua")));
				sp.setLoaiSua(loaiSuaDao.get(rs.getString("ma_loai_sua")));
				sp.setTrongLuong(rs.getInt("trong_luong"));
				sp.setDonGia(rs.getInt("don_gia"));
				sp.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				sp.setLoiIch(rs.getString("loi_ich"));
				sp.setHinh(rs.getString("hinh"));
				ds.add(sp);
			}
			return ds;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean update(String ma) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<SanPham> search(String keyword) {
		List<SanPham> ds = null;
		hangSuaDao = new HangSuaDAO();
		loaiSuaDao = new LoaiSuaDAO();
		String sql = "select * from sua where ten_sua LIKE '%"+keyword.trim()+"%'";

		conn = CSDL.getKetNoi();
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			ds = new ArrayList<SanPham>();
			while (rs.next()) {

				SanPham sp = new SanPham();
				sp.setMaSua(rs.getString("ma_sua"));
				sp.setTenSua(rs.getString("ten_sua"));
				sp.setHangSua(hangSuaDao.get(rs.getString("ma_hang_sua")));
				sp.setLoaiSua(loaiSuaDao.get(rs.getString("ma_loai_sua")));
				sp.setTrongLuong(rs.getInt("trong_luong"));
				sp.setDonGia(rs.getInt("don_gia"));
				sp.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				sp.setLoiIch(rs.getString("loi_ich"));
				sp.setHinh(rs.getString("hinh"));
				ds.add(sp);
			}
			return ds;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public static void main(String[] args) {
		SanPhamDAO dao = new SanPhamDAO();
		List<SanPham> list = dao.search("Gain     ");
		System.out.println(list.size());
	}

	public List<SanPham> search(String keyword, String tenLoaiSua, String tenhangSua) {
		// TODO Auto-generated method stub
		List<SanPham> ds = null;
		hangSuaDao = new HangSuaDAO();
		loaiSuaDao = new LoaiSuaDAO();
		String sql = "select * from sua AS s INNER JOIN hang_sua AS hs ON s.Ma_hang_sua = hs.Ma_hang_sua "
				+ "INNER JOIN loai_sua AS ls ON s.Ma_loai_sua = ls.Ma_loai_sua WHERE hs.Ten_hang_sua "
				+ "LIKE '%"+tenhangSua+"%' AND ls.Ten_loai LIKE '%"+tenLoaiSua+"%' "
						+ "AND s.ten_sua LIKE '%"+keyword.trim()+"%'";

		conn = CSDL.getKetNoi();
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			ds = new ArrayList<SanPham>();
			while (rs.next()) {

				SanPham sp = new SanPham();
				sp.setMaSua(rs.getString("ma_sua"));
				sp.setTenSua(rs.getString("ten_sua"));
				sp.setHangSua(hangSuaDao.get(rs.getString("ma_hang_sua")));
				sp.setLoaiSua(loaiSuaDao.get(rs.getString("ma_loai_sua")));
				sp.setTrongLuong(rs.getInt("trong_luong"));
				sp.setDonGia(rs.getInt("don_gia"));
				sp.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				sp.setLoiIch(rs.getString("loi_ich"));
				sp.setHinh(rs.getString("hinh"));
				ds.add(sp);
			}
			return ds;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
