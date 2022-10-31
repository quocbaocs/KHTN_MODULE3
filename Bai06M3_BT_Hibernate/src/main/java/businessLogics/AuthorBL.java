package businessLogics;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Author;

public class AuthorBL {
	public static List<Author> getAuthor() {
		try (Session session = CSDL.getSessionFacotry().openSession()) {
			return session.createQuery("from Author").list();
		} catch (Exception e) {
			return null;
		}

	}

	public static boolean add(Author obj) {
		Transaction tran = null;
		try (Session session = CSDL.getSessionFacotry().openSession()) {
			tran = session.beginTransaction();
			session.save(obj);
			tran.commit();
			return true;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			return false;
		}
	}

	public static boolean edit(Author obj) {
		Transaction tran = null;
		try (Session session = CSDL.getSessionFacotry().openSession()) {
			tran = session.beginTransaction();
			session.update(obj);
			tran.commit();
			return true;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			return false;
		}
	}

	public static boolean delete(int id) {
		Transaction tran = null;
		try (Session session = CSDL.getSessionFacotry().openSession()) {
			tran = session.beginTransaction();
			session.delete(new Author(id, null));
			tran.commit();
			return true;
		} catch (Exception ex) {
			if (tran != null) {
				tran.rollback();
			}
			return false;
		}
	}
	public static Author getAuthor(int id) {
		String sql = "select * from Author where authorId=:id";
		Object author = null;
		try (Session session = CSDL.getSessionFacotry().openSession()) {
			author = session.get(Author.class, id);
			
		} catch (Exception ex) {
			return null;
		}
		return  (Author) author;
	}
	public static void main(String[] args) {
		System.out.println(getAuthor(5).getAuthorName());
	}


}
