package repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import exceptions.DatabaseException;

public class CrudRepositoryConfiguration<T, I extends Serializable> implements CrudRepository<T, I> {

	    @PersistenceContext
	    private EntityManager entityManager;

	    public EntityManager getEntityManager() {
			return entityManager;
		}
	    
		public void setEntityManager(final EntityManager entityManager) {
			this.entityManager = entityManager;
		}

		
	    private static Class<?> getEntityInterface(Class<?> daoHibernateClass) {
	        Type superclass = daoHibernateClass.getGenericSuperclass();
	        if (superclass instanceof ParameterizedType) {
	            return (Class<?>) ((ParameterizedType) superclass).getActualTypeArguments()[0];
	        }
	        return getEntityInterface((Class<?>) superclass);
	    }

	    @Override
	    @SuppressWarnings("unchecked")
	    public T get(I id) {
	        return (T) entityManager.find(getEntityInterface(getClass()), id);
	    }

	    @Override
	    public void save(T entity) {
	    	entityManager.persist(entity);
	    }

	    @Override
	    public void update(T entity) {
	        entityManager.merge(entity);
	    }

	    @Override
	    public void delete(T entity) throws DatabaseException {
	        entityManager.remove(entity);
	    }

	    @Override
		public void flush() {
			this.entityManager.flush();
		}

}
