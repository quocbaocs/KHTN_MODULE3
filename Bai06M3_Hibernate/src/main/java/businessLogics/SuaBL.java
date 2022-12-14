package businessLogics;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entities.Sua;

public class SuaBL {
	public static List<Sua> docTatCa() {
		String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua";
		try (Session session = CSDL.getSessionfactory().openSession()) {
			return session.createQuery(sql, Sua.class).list();

		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	// Thực hiện câu truy vấn có tham số
	public static List<Sua> docTheoMaHang(String maHang) {
		String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua where s.hangSua.maHangSua = :maHang";
		try (Session session = CSDL.getSessionfactory().openSession()) {
			return session.createQuery(sql, Sua.class)
					.setParameter("maHang", maHang)
					.list();

		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	// Thực hiện câu truy vấn có tham số
	public static List<Sua> docTheoLoaiHangTen(String maLoai, String maHang, String tenSua) {
		String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua where s.hangSua.maHangSua = :maHang and s.loaiSua.maLoaiSua =:maLoai and s.tenSua like :tenSua";
		try (Session session = CSDL.getSessionfactory().openSession()) {
			return session.createQuery(sql, Sua.class)
					.setParameter("maHang", maHang)
					.setParameter("maLoai", session)
					.setParameter("tenSua", "%" + tenSua + "%")
					.list();

		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	// Câu truy vấn có giới hạn mẫu tin
	public static List<Sua> suaGiaCao(int top) {
		String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua order by s.donGia desc";
		try (Session session = CSDL.getSessionfactory().openSession()) {
			return session.createQuery(sql, Sua.class)
					.setFirstResult(top)
					.setMaxResults(top)
					.list();

		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	
	public static List<Sua> suaBanChay(int top) {
		String sql = "select s, sum(ct.soLuong) as tsl from Sua s join s.ctHoadons ct left join fetch s.hangSua left join fetch s.loaiSua group by s order by tsl desc ";

		List<Sua> dsSua = new ArrayList<Sua>();
		try (Session session = CSDL.getSessionfactory().openSession()) {
			List<Object> dsObj = session.createQuery(sql)
					.setFirstResult(top)
					.setMaxResults(top)
					.list();
			for (Object obj : dsObj) {
				Object[] mc = (Object[]) obj;
				Sua s = (Sua) mc[0];
				dsSua.add(s);
			}

		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		return dsSua;
	}

	public static void main1(String[] args) {
		List<Sua> ds = docTatCa();
		ds.forEach(s -> System.out
				.println(s.getTenSua() + " - " + s.getHangSua().getTenHangSua() + " - " + s.getLoaiSua().getTenLoai()));
	}

	public static void main2(String[] args) {
		List<Sua> ds = docTheoMaHang("DL");
		ds.forEach(s -> System.out
				.println(s.getTenSua() + " - " + s.getHangSua().getTenHangSua() + " - " + s.getLoaiSua().getTenLoai()));
	}

	public static void main(String[] args) {
		List<Sua> ds = docTheoLoaiHangTen("SB", "DL", "Cô gái");
		ds.forEach(s -> System.out
				.println(s.getTenSua() + " - " + s.getHangSua().getTenHangSua() + " - " + s.getLoaiSua().getTenLoai()));
	}

	public static void main4(String[] args) {
		List<Sua> ds = suaGiaCao(1);
		ds.forEach(s -> System.out
				.println(s.getTenSua() + " - " + s.getHangSua().getTenHangSua() + " - " + s.getLoaiSua().getTenLoai()));
	}
	public static void main6(String[] args) {
		List<Sua> ds = suaBanChay(3);
		ds.forEach(s -> System.out
				.println(s.getTenSua() + " - " + s.getHangSua().getTenHangSua() + " - " + s.getLoaiSua().getTenLoai()));
	}

}
