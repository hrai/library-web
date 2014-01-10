
package com.csu.library.mvc.dao.generic;

import java.io.Serializable;
import java.util.Collection;

public interface GenericDao<T, ID extends Serializable> {
    //CRUD technique is applied
    public T find(ID id, boolean lock);
    public Collection<T> findAll();
    public Collection<T> findByExample(T exampleInstance);
    public void save(T instance);
    public void update(T instance);
    public void delete(T instance);
    
}
