
package com.csu.library.mvc.dao.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.springframework.transaction.annotation.Transactional;

import com.csu.library.mvc.hibernate.HibernateUtil;

@Transactional
public abstract class GenericHibernateDao<T, ID extends Serializable> implements GenericDao<T, ID> {
    private Class<T> persistentClass;
    protected Session session;
    @Inject
    private HibernateUtil hibernateUtil;
    
    @SuppressWarnings("unchecked")
	public GenericHibernateDao() {
        this.persistentClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    public SessionFactory getSessionFactory() {
    	return hibernateUtil.getSessionFactory();
    }
    
    public Class<T> getPersistentClass() {
        return persistentClass;
    }

	@SuppressWarnings("unchecked")
	public T find(ID id, boolean lock) {
		T entity;
		if(lock) {
			entity = (T) getSessionFactory().getCurrentSession().load(getPersistentClass(), id, LockOptions.UPGRADE);
		}
		else
			entity = (T) getSessionFactory().getCurrentSession().load(getPersistentClass(), id);
		
		return entity;
	}

	@SuppressWarnings("unchecked")
	public Collection<T> findByExample(T exampleInstance) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass());
		criteria.add(Example.create(exampleInstance));
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public Collection<T> findAll() {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass());
		return criteria.list();
	}

	public void save(T instance) {
		getSessionFactory().getCurrentSession().save(instance);
	}

	public void update(T instance) {
		getSessionFactory().getCurrentSession().update(instance);
	}

	public void delete(T instance) {
		getSessionFactory().getCurrentSession().delete(instance);
	}

	@SuppressWarnings("unchecked")
	protected Collection<T> findByCriteria(Collection<Criterion> c) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass());
		for(Criterion criterion: c) {
			criteria.add(criterion);
		}
		
		return criteria.list();
	}

}
