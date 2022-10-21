package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javaBeans.SanPham;

public class SanPhamBL implements DAO<SanPham> {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	@Override
	public List<SanPham> listAll() {
		List<SanPham> ds = new ArrayList<>();
		SanPham sp = null;
		String query = "SELECT * FROM sanpham ORDER BY ngaytao DESC LIMIT 0,10";

		conn = CSDL.getKetNoi();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				sp = new SanPham();
				sp.setId(rs.getInt("id"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				sp.setMoTa(rs.getString("mota"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setNgayTao(rs.getDate("ngaytao"));
				sp.setHienThi(rs.getInt("hienthi"));
				sp.setIdLoai(rs.getInt("id_loai"));
				sp.setIdThuongHieu(rs.getInt("id_thuong_hieu"));
				ds.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return ds;
	}

	public List<SanPham> listNew() {
		List<SanPham> ds = new ArrayList<>();
		SanPham sp = null;
		String query = "SELECT * FROM sanpham ORDER BY ngaytao DESC LIMIT 0,10";

		conn = CSDL.getKetNoi();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				sp = new SanPham();
				sp.setId(rs.getInt("id"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				sp.setMoTa(rs.getString("mota"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setNgayTao(rs.getDate("ngaytao"));
				sp.setHienThi(rs.getInt("hienthi"));
				sp.setIdLoai(rs.getInt("id_loai"));
				sp.setIdThuongHieu(rs.getInt("id_thuonghieu"));
				ds.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return ds;
	}

	public List<SanPham> listGiamGia() {
		List<SanPham> ds = new ArrayList<>();
		SanPham sp = null;
		String query = "SELECT * FROM sanpham ORDER BY dongiaKM DESC LIMIT 0,3";

		conn = CSDL.getKetNoi();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				sp = new SanPham();
				sp.setId(rs.getInt("id"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				sp.setMoTa(rs.getString("mota"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setNgayTao(rs.getDate("ngaytao"));
				sp.setHienThi(rs.getInt("hienthi"));
				sp.setIdLoai(rs.getInt("id_loai"));
				sp.setIdThuongHieu(rs.getInt("id_thuonghieu"));
				ds.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return ds;
	}

	public List<SanPham> listBanNhieuNhat() {
		List<SanPham> ds = new ArrayList<>();
		SanPham sp = null;
		String query = "SELECT *,count(id_donhang) FROM sanpham sp INNER JOIN chitietdonhang ctdh ON sp.id = ctdh.id_sanpham "
				+ "GROUP BY id_donhang ORDER BY COUNT(id_donhang) desc LIMIT 0,3";

		conn = CSDL.getKetNoi();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				sp = new SanPham();
				sp.setId(rs.getInt("id"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				sp.setMoTa(rs.getString("mota"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setNgayTao(rs.getDate("ngaytao"));
				sp.setHienThi(rs.getInt("hienthi"));
				sp.setIdLoai(rs.getInt("id_loai"));
				sp.setIdThuongHieu(rs.getInt("id_thuonghieu"));
				ds.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return ds;
	}

	@Override
	public SanPham find(int id) {
		SanPham sp = null;
		String query = "SELECT * FROM sanpham WHERE id="+id;
		conn = CSDL.getKetNoi();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				sp = new SanPham();
				sp.setId(rs.getInt("id"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				sp.setMoTa(rs.getString("mota"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setNgayTao(rs.getDate("ngaytao"));
				sp.setHienThi(rs.getInt("hienthi"));
				sp.setIdLoai(rs.getInt("id_loai"));
				sp.setIdThuongHieu(rs.getInt("id_thuonghieu"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return sp;
		
	}

	@Override
	public int insert(SanPham t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(SanPham t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Map<String, Object>listPhanTrang(int page) throws SQLException {
		int soDongTrang = 12, trang = page;
		
		List<SanPham> ds = new ArrayList<>();
		SanPham sp = null;
		String query = "SELECT * FROM sanpham";
		conn = CSDL.getKetNoi();

		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		rs.last();
		int tsd = rs.getRow();
		System.out.println(tsd);
		int tongSoTrang = tsd / soDongTrang + (tsd % soDongTrang != 1 ? 1 : 0);

		int vt = (trang - 1) * soDongTrang;
		
		 Map<String, Object> result;
		try {
			rs = stmt.executeQuery(query + " LIMIT "+vt+","+soDongTrang);
			result = new HashMap<>();
			while (rs.next()) {
				sp = new SanPham();
				sp.setId(rs.getInt("id"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				sp.setMoTa(rs.getString("mota"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setNgayTao(rs.getDate("ngaytao"));
				sp.setHienThi(rs.getInt("hienthi"));
				sp.setIdLoai(rs.getInt("id_loai"));
				sp.setIdThuongHieu(rs.getInt("id_thuonghieu"));
				ds.add(sp);
			}
			result.put("listSP", ds);
			result.put("tongSoTrang", tongSoTrang);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return result;
	}

	public static void main(String[] args) throws SQLException {
		SanPhamBL bl = new SanPhamBL();
		
		System.out.println(bl.listPhanTrang(2).toString());
	}
	
	public List<SanPham> listSanPhamCungThuongHieu(int id) {
		List<SanPham> ds = new ArrayList<>();
		SanPham sp = null;
		String query = "SELECT * FROM SANPHAM WHERE id_thuonghieu=(SELECT id_thuonghieu FROM sanpham WHERE id="+id+");";

		conn = CSDL.getKetNoi();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				sp = new SanPham();
				sp.setId(rs.getInt("id"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				sp.setMoTa(rs.getString("mota"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setNgayTao(rs.getDate("ngaytao"));
				sp.setHienThi(rs.getInt("hienthi"));
				sp.setIdLoai(rs.getInt("id_loai"));
				sp.setIdThuongHieu(rs.getInt("id_thuonghieu"));
				ds.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return ds;
	}

}
