package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javaBeans.HangSua;

public class HangSuaBL {
	private static final SessionFactory factory = CSDL.getSessionFactory();

	public static List<HangSua> getAllHangSua() {
		String sql = "select hs from HangSua hs";
		try (Session session = factory.openSession()) {

			return session.createQuery(sql, HangSua.class).list();

		} catch (Exception e) {
			return null;
		}
	}

	public static HangSua getHangSua(String maHang) {

//		String sql = "select hs from HangSua hs where hs.maHangSua=:maHang";
		try (Session session = factory.openSession()) {
			return session.get(HangSua.class, maHang);
//			return session.createQuery(sql, HangSua.class).setParameter("maHang", maHang).list().get(0);

		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(getHangSua("AB").getTenHangSua());
	}

}
