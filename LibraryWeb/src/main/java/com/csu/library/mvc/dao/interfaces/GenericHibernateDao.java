/*package com.csu.library.mvc.dao.interfaces;

import java.lang.reflect.*;
import java.io.Serializable;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.csu.library.mvc.hibernate.HibernateUtil;

public abstract class GenericHibernateDao<T, ID extends Serializable> implements GenericDao<T, ID>{
    private Class<T> persistentClass;
    private Session session;
    
    @SuppressWarnings("unchecked")
	public GenericHibernateDao() {
    	this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    public Session getSession() {
    	if(session == null) {
        	this.session = new HibernateUtil().getSession();
        }
        return session;
    }
    
    public void setSession(Session session) {
       this.session = session;
    }
    
    public Class<T> getPersistentClass() {
        return persistentClass;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public T find(ID id, boolean lock) {
    	T entity;
    	
    	if(lock) {
    		entity = (T) getSession().load(getPersistentClass(), id, LockOptions.UPGRADE);
    	}
    	else 
    		entity = (T) getSession().load(getPersistentClass(), id);
    	
    	return entity;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public Collection<T> find(T exampleEntity) {
    	Example example = Example.create(exampleEntity);
    	Criteria criteria = getSession().createCriteria(getPersistentClass());
    	criteria.add(example);
    	
    	return criteria.list();
    }
    
    @Override
    public Collection<T> findAll() {
    	Example example = Example.create(getPersistentClass());
    	Criteria criteria = getSession().createCriteria(getPersistentClass());
    	criteria.add(example);
    	
        return findByCriteria(criteria);
    }
    
	@Override
    public void save(T entity) {
        getSession().save(entity);
    }
    
    @Override
    public void update(T entity) {
    	getSession().update(entity);
    }
    
    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
	private Collection<T> findByCriteria(Criteria criteria) {
		return criteria.list();
	}

}
*/