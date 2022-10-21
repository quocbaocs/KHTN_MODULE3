package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Loai;

public class LoaiBL implements DAO<Loai> {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	@Override
	public  List<Loai> listAll() {
		List<Loai> ds  = new ArrayList<>();
		Loai l = null;
		String query = "SELECT * FROM LOAI";
		
		conn = CSDL.getKetNoi();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				l = new Loai();
				l.setId(rs.getInt("id"));
				l.setTenLoai(rs.getString("tenloai"));
				ds.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return ds;
	}

	@Override
	public Loai find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Loai t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Loai t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		LoaiBL bl = new LoaiBL();
		System.out.println(bl.listAll().size());
	}
}
