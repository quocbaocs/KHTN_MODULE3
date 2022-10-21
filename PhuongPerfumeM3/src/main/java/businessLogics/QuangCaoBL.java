package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.QuangCao;

public class QuangCaoBL {
	public static List<QuangCao> docTatCa(){
		List<QuangCao> dsqc = new ArrayList<QuangCao>();
		String sql = "select * from quangcao";
		try(Connection kn=CSDL.getKetNoi()) {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				QuangCao qc = new QuangCao();
				qc.setId(rs.getInt("id"));
				qc.setHinhAnh(rs.getString("hinhanh"));
				qc.setThongDiep(rs.getString("thongdiep"));
				qc.setThongTinChiTiet(rs.getString("thongtinchitiet"));
				qc.setNgayDang(rs.getDate("ngaydang"));
				dsqc.add(qc);
			}
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		return dsqc;
	}

	public static void main(String[] args) {
		List<QuangCao> ds = docTatCa();
		for(QuangCao qc:ds) {
			System.out.println(qc.getThongDiep());
		}
	}
}
