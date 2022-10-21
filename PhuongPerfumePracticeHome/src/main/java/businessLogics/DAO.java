package businessLogics;

import java.util.List;

public interface DAO<T> {
	List<T> listAll();

	T find(int id);

	int insert(T t);

	int delete(int id);

	int update(T t);

}
