package repository;

import java.util.List;
import entities.User;
import exceptions.DatabaseException;

public interface UserRepository extends CrudRepository<User, Long>
{
	List<User> listAllOrderByName() throws DatabaseException;
	
	boolean existUser(String name) throws DatabaseException;
}
