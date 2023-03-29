package projetFinal.dao;

import java.util.List;

public interface DaoGenerique<T, K> {
	
	T save(T obj);
	void delete(T obj);
	void deleteByKey(K key);
	T findByKey(K key);
	List<T> findAll();

}
