package businessLogics;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javaBeans.User;

public class UserBL {
	private static final SessionFactory factory = CSDL.getSessionFactory();

	private static String sha256(String plantext) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			return String.valueOf(digest.digest(plantext.getBytes("UTF-8")));

		} catch (Exception e) {
			return null;
		}
	}

	private static long random() {
		Random rand = new Random();
		long a = rand.nextInt();
		long b = rand.nextInt();
		return a * b;
	}

	public static void themUser(User usr) {
		Transaction tx = null;
		try (Session session = factory.openSession()) {
			tx = session.beginTransaction();
			
			usr.setUserId(random());
			usr.setAddedDate(new Date());
			session.persist(usr);
			usr.setPassword(sha256(usr.getPassword()));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		User usr = new User("a","a", "quoc bao", "le quoc bao", (byte) 0);
		themUser(usr);
	}

}
