package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataTransferObject.HangSua;
import dataTransferObject.LoaiSua;

public class LoaiSuaDAO implements DAO<LoaiSua>{
	private Connection conn;
	
	public LoaiSuaDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LoaiSua get(String ma) {
		String sql = "select * from loai_sua where ma_loai_sua='" + ma + "'";
		Statement stmt = null;
		ResultSet rs = null;
		conn = CSDL.getKetNoi();

		try {
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(sql);
			if (rs.next()) {
				LoaiSua ls = new LoaiSua();
				ls.setMaLoaiSua(rs.getString("ma_loai_sua"));
				ls.setTenLoaiSua(rs.getString("ten_loai"));
				return ls;
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
	public boolean insert(LoaiSua t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(String ma) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LoaiSua> list() {
		List<LoaiSua> list = null;
		String sql = "select * from loai_sua";
		Statement stmt = null;
		ResultSet rs = null;
		conn = CSDL.getKetNoi();

		try {
			list = new ArrayList<LoaiSua>();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(sql);
			while (rs.next()) {
				LoaiSua ls = new LoaiSua();
				ls.setMaLoaiSua(rs.getString("ma_loai_sua"));
				ls.setTenLoaiSua(rs.getString("ten_loai"));
				list.add(ls);
			}
			return list;
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
	public boolean update(String ma) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
