package repository;

import java.io.Serializable;

public interface CrudRepository<T, I extends Serializable> {

	T get(I id);

	void save(T entity);

	void update(T entity);

	void delete(T entity);

	void flush();
}
