package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.SanPham;

public class ThuongHieuBL implements DAO<ThuongHieu>{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	@Override
	public List<ThuongHieu> listAll() {
		List<ThuongHieu> ds = new ArrayList<>();
		ThuongHieu th = null;
		String query = "SELECT * FROM thuonghieu";

		conn = CSDL.getKetNoi();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				th = new ThuongHieu();
				th.setId(rs.getInt("id"));
				th.setHinhAnh(rs.getString("hinhanh"));
				th.setTenThuongHieu(rs.getString("tenthuonghieu"));
				ds.add(th);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return ds;
	}

	@Override
	public ThuongHieu find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ThuongHieu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ThuongHieu t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
