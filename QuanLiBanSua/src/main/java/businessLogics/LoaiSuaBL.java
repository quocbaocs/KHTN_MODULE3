package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javaBeans.LoaiSua;

public class LoaiSuaBL {
	private static final SessionFactory factory = CSDL.getSessionFactory();

	public static List<LoaiSua> getAllLoaiSua() {
		String sql = "select ls from LoaiSua ls";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, LoaiSua.class).list();

		} catch (Exception e) {
			return null;
		}
	}

	public static LoaiSua getLoaiSua(String maLoai) {

		try (Session session = factory.openSession()) {
			return session.get(LoaiSua.class, maLoai);

		} catch (Exception e) {
			return null;
		}

	}
	public static void main(String[] args) {
		System.out.println(getLoaiSua("SB").getTenLoai());
	}

}
