package dao;

import java.util.List;

import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Remote;

@Remote
public interface IDao <T> {
	@PermitAll
	boolean create(T o);
	@PermitAll
	boolean update(T o);
	@PermitAll
	boolean delete(T o);
	@PermitAll
	T findById(int id);
	@PermitAll
	List<T> findAll();

}
