package repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import entities.User;
import exceptions.DatabaseException;

@Repository
public class UserRepositoryImpl extends CrudRepositoryConfiguration<User, Long> implements UserRepository {

	@Override
	public List<User> listAllOrderByName() throws DatabaseException {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> user = criteriaQuery.from(User.class);
		
		criteriaQuery.select(user).orderBy(builder.asc(user.get("name")));
		TypedQuery<User> typedQuerry = getEntityManager().createQuery(criteriaQuery);
		return typedQuerry.getResultList();
	}

	@Override
	public boolean existUser(String name) throws DatabaseException {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> user = criteriaQuery.from(User.class);
		
		Predicate predicate = builder.like(user.get("name"),name);
		criteriaQuery.select(user).where(predicate);
		
		TypedQuery<User> typedQuerry = getEntityManager().createQuery(criteriaQuery);
		if(typedQuerry.getResultList().isEmpty())
		{
			return false;
		}
		
		return true;
	}


}
