package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DAO<T> {
	T get(int id) throws SQLException;
	
	List<T> getAll() throws SQLException;
	
	void insert(T t) throws SQLException;
	
	void update(T t, Map<String,String> map) throws SQLException;
	
	void delete(T t) throws SQLException;

}
