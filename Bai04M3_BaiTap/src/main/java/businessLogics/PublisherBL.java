package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javaBeans.Publisher;

public class PublisherBL {
	private static final SessionFactory factory = CSDL.getSessionFactory();

	public static List<Publisher> getPublishers() {
		List<Publisher> ds = null;
		try (Session session = factory.openSession()) {
			String sql = "select pl from Publisher pl";
			ds = session.createQuery(sql, Publisher.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return ds;
	}

	public static boolean them(Publisher p) {
		Transaction tx = null;
		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			session.persist(p);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				return false;
			}
		}
		return true;
	}

	public static void xoa(int id) {
		Transaction tx = null;
		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			Publisher p = session.get(Publisher.class, id);
			session.delete(p);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
	}

	public static void sua(Publisher p) {
		Transaction tx = null;
		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			session.merge(p);
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}
	}

	public static Publisher getPublisher(int id) {
		Publisher p;
		try (Session session = factory.openSession()) {
			p = session.get(Publisher.class, id);

		} catch (Exception e) {
			return null;
		}
		return p;
	}

	
}
