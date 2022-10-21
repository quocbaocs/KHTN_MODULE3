package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javaBeans.NguoiDung;

public class NguoiDungBL {
	public static NguoiDung docTheoEmailPassword(String email, String password) {
		NguoiDung nd = null;
		String sql = "select * from nguoidung where email='"+email+"' AND password='"+password+"'";
		try (Connection kn = CSDL.getKetNoi()){
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				nd = new NguoiDung();
				nd.setId(rs.getInt("id"));
				nd.setEmail(rs.getString("email"));
				nd.setHoTen(rs.getString("hoten"));
				nd.setPassword(rs.getString("password"));
				nd.setDiaChi(rs.getString("diachi"));
				nd.setDtdd(rs.getString("dtdd"));
				nd.setIdVaiTro(rs.getInt("id_vaitro"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nd;
	}
	public static void main(String[] args) {
		NguoiDung nd = docTheoEmailPassword("bichle@gmail.com", "bichle");
		if(nd!=null) {
			System.out.println(nd.getHoTen());
		}else {
			System.out.println("Email or Password sai");
		}
	}

}
