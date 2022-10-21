package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.QuangCao;

public class QuangCaoBL implements DAO<QuangCao> {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs ;
	@Override
	public List<QuangCao> listAll() {
		List<QuangCao> ds  = new ArrayList<>();
		QuangCao qc = null;
		String query = "SELECT * FROM QUANGCAO";
		
		conn = CSDL.getKetNoi();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				qc = new QuangCao();
				qc.setId(rs.getInt("id"));
				qc.setHinhAnh(rs.getString("hinhanh"));
				qc.setThongDiep(rs.getString("thongdiep"));
				qc.setThongTinChiTiet(rs.getString("thongtinchitiet"));
				qc.setNgayDang(rs.getDate("ngaydang"));
				ds.add(qc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return ds;
	}

	@Override
	public QuangCao find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(QuangCao t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(QuangCao t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
