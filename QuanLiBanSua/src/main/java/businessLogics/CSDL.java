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
	
}
