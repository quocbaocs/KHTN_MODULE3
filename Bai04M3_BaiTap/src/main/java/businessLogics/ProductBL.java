package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javaBeans.Product;

public class ProductBL {
	private static final SessionFactory factory = CSDL.getSessionFactory();

	public static int tongSoTrang(int soDongTrang) {
		String sql = "select p from Product p";
		int tongSoDong = 0;
		int tongSoTrang = 0;
		try (Session session = factory.openSession()) {
			tongSoDong = session.createQuery(sql).list().size();
			tongSoTrang = tongSoDong / soDongTrang + (tongSoDong % soDongTrang == 0 ? 0 : 1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tongSoTrang;
	}

	public static List<Product> sanPhamTrang(int trang, int soDongTrang) {

		int viTriDau = (trang == 1 ? 0 : (trang - 1) * soDongTrang);
		String sql = "select p from Product p";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, Product.class).setFirstResult(viTriDau).setMaxResults(soDongTrang).list();
		} catch (Exception e) {
			return null;
		}

	}

	public static Product getProduct(int id) {

		try (Session session = factory.openSession()) {
			return session.get(Product.class, id);
		} catch (Exception e) {
			return null;
		}

	}

	public static List<Product> search(String keyword) {
		String sql = "select p from Product p where p.title like :title";
		try (Session session = factory.openSession()) {
			return session.createQuery(sql, Product.class).setParameter("title", "%" + keyword + "%").list();

		} catch (Exception e) {
			return null;
		}

	}

	public static void main(String[] args) {
		System.out.println(search("C#").size());
	}
}
