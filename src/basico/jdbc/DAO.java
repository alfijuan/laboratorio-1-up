package basico.jdbc;

import java.util.List;

public interface DAO<T, K> {
	
	void insert(T a);
	
	void modify(T a);
	
	void delete(T a);
	
	List<T> getAll(T a);
	
	T get(K id);
}
