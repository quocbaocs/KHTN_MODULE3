package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javaBeans.KhachHang;

public class KhachHangBL {
	private static final SessionFactory factory = CSDL.getSessionFactory();

	public static List<KhachHang> getAllKhachHang() {
		String sql = "select kh from KhachHang kh";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, KhachHang.class).list();
		} catch (Exception e) {
			return null;
		}
	}

	public static int tongSoTrang(int soDongTrang) {
		String sql = "select kh from KhachHang kh";
		try (Session session = factory.openSession()) {
			int tongSoDong = session.createQuery(sql, KhachHang.class).list().size();
			int tongSoTrang = tongSoDong / soDongTrang + (tongSoDong % soDongTrang == 0 ? 0 : 1);
			return tongSoTrang;

		} catch (Exception e) {
			return 0;
		}
	}

	public static List<KhachHang> KhachHangTrang(int trang, int soDongTrang) {
		String sql = "select kh from KhachHang kh";
		int viTriDau = (trang == 1 ? 0 : (trang - 1) * soDongTrang);
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, KhachHang.class).setFirstResult(viTriDau).setMaxResults(soDongTrang).list();

		} catch (Exception e) {
			return null;
		}
	}

	public static KhachHang getKhachHang(String maKH) {

		try (Session session = factory.openSession()) {
			return session.get(KhachHang.class, maKH);

		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(KhachHangBL.tongSoTrang(5));
	}

	public static boolean capNhatKhachHang(KhachHang kh) {
		Transaction tx = null;
		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			session.saveOrUpdate(kh);
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			return false;
		}

	}

	public static boolean delete(String makh) {
		Transaction tx = null;
		try (Session session = factory.openSession()) {

			tx = session.beginTransaction();
			KhachHang kh = session.get(KhachHang.class, makh);
			session.delete(kh);
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return false;
		}

	}

}
