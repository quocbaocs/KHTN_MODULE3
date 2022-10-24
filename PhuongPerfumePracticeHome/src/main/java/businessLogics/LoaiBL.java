package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Loai;

public class LoaiBL{

	public static  List<Loai> docTatCa() {
		List<Loai> ds  = new ArrayList<>();
		Loai l = null;
		String query = "SELECT * FROM LOAI";
		
		
		try(Connection kn = CSDL.getKetNoi()) {
			Statement stmt = kn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
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

}
