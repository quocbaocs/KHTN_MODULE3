package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.ThuongHieu;

public class ThuongHieuBL {
	public static List<ThuongHieu> docTatCa() {
		List<ThuongHieu> dsth = new ArrayList<ThuongHieu>();
		String sql = "select * from thuonghieu";
		try (Connection kn = CSDL.getKetNoi()) {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ThuongHieu th = new ThuongHieu();
				th.setId(rs.getInt("id"));
				th.setHinhAnh(rs.getString("hinhanh"));
				th.setTenThuongHieu(rs.getString("tenthuonghieu"));
				dsth.add(th);
			}
		} catch (Exception e) {
			return null;
		}
		return dsth;
	}
	public static void main(String[] args) {
		List<ThuongHieu> ds = docTatCa();
		ds.forEach(s->System.out.println(s.getTenThuongHieu()));
	}
}
