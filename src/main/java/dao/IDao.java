package dao;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

	//public static final int EXITO = 0;

	//public static final int FALLO = -1;

	Optional<T> get(long id);

	List<T> getAll();

	void save(T t);

	void update(T t);

	void delete(T t);

}
