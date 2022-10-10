package businessLogics;

import java.util.List;

public interface DAO<T> {
	T get(String ma);

	boolean insert(T t);

	void delete(String ma);
	
	List<T> list() ;
	
	boolean update(String ma);
	

}
