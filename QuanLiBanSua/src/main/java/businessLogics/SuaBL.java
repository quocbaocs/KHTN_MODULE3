package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javaBeans.Sua;

public class SuaBL {
	private static final SessionFactory factory = CSDL.getSessionFactory();

	public static boolean themSua(Sua newSua) {
		Transaction tx = null;
		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			session.persist(newSua);
			tx.commit();
			return true;

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();

			}
			return false;

		}
	}

	public static int tongSoTrang(int soDongTrang) {

		int tongSoDong;
		int tongSoTrang;

		String sql = "select s from Sua s";
		try (Session session = factory.openSession()) {

			tongSoDong = session.createQuery(sql, Sua.class).list().size();
			tongSoTrang = tongSoDong / soDongTrang + (tongSoDong % soDongTrang == 0 ? 0 : 1);

			return tongSoTrang;
		} catch (Exception e) {
			return 0;
		}

	}

	public static List<Sua> danhSachSuaTrang(int trang, int soDongTrang) {
		String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua";

		int viTriDau = (trang == 1 ? 0 : (trang - 1));

		try (Session session = factory.openSession()) {
			return session.createQuery(sql, Sua.class).setFirstResult(viTriDau).setMaxResults(soDongTrang).list();
		} catch (Exception e) {
			return null;
		}

	}

	public static Sua getSua(String maSua) {

		try (Session session = factory.openSession()) {

			return session.get(Sua.class, maSua);
		} catch (Exception e) {

			return null;
		}
	}

	public static List<Sua> timTheoLoaiHangTen(String maLoai, String maHang, String tenSua) {
		String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua where s.hangSua.maHangSua = :maHang and s.loaiSua.maLoaiSua =:maLoai and s.tenSua like :tenSua";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, Sua.class).setParameter("maHang", maHang).setParameter("maLoai", maLoai)
					.setParameter("tenSua", "%" + tenSua + "%").list();

		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}

	}

	

	public static List<Sua> docTheoHang(String maHang) {
		String sql = "select s from Sua s left join fetch s.hangSua where s.hangSua.maHangSua=:maHang";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, Sua.class).setParameter("maHang", maHang).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static List<Sua> docTheoLoai(String maLoai) {
		String sql = "select s from Sua s left join fetch s.hangSua where s.loaiSua.maLoaiSua=:maLoai";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, Sua.class).setParameter("maLoai", maLoai).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		List<Sua> ds = docTheoLoai("SB");
		for(Sua s: ds) {
			System.out.println(s.getTenSua());
		}
	}

}
