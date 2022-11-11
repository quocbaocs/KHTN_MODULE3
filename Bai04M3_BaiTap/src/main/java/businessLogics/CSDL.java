package businessLogics;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CSDL {
	private static final SessionFactory factory;
	static {
		factory = new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}
	public static void main(String[] args) {
		SessionFactory factory = getSessionFactory();
		if(factory!=null) {
			System.out.println("ket noi thanh cong");
		}else {
			System.out.println("ket noi that bai");
		}
	}

}
