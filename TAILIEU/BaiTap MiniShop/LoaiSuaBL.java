package businessLogics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.LoaiSua;

public class LoaiSuaBL {
	private static final SessionFactory factory = CSDL.getFactory();
	public static List<LoaiSua> docTatCa(){
		String sql = "select l from LoaiSua l";
		try (Session session = factory.openSession()){
			return session.createQuery(sql, LoaiSua.class).list();
		} catch (Exception e) {
			return null;
		}
	}
	public static LoaiSua tim(String ml){
		try (Session session = factory.openSession()){
			return session.get(LoaiSua.class, ml);
		} catch (Exception e) {
			return null;
		}
	}
	public static void them(LoaiSua ls) {
		Transaction tx = null;
		try (Session session = factory.openSession()){
			tx = session.beginTransaction();
			session.persist(ls);
			tx.commit();
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
		}
	}
	public static void sua(LoaiSua ls) {
		Transaction tx = null;
		try (Session session = factory.openSession()){
			tx = session.beginTransaction();
			session.merge(ls);
			tx.commit();
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
		}
	}
	public static void xoa(String maLoai) {
		Transaction tx = null;
		try (Session session = factory.openSession()){
			tx = session.beginTransaction();
			LoaiSua lsx = session.get(LoaiSua.class, maLoai);
			session.delete(lsx);
			tx.commit();
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
		}
	}
//	public static void main(String[] args) {
//		LoaiSua ls = new LoaiSua();
//		ls.setMaLoaiSua("AA");
//		ls.setTenLoai("Sữa AAABBB");
//		xoa(ls);
//	}
}
