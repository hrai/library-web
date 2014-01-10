package com.csu.library.mvc.dao;

import com.csu.library.mvc.dao.generic.GenericDao;
import com.csu.library.mvc.dto.*;

import java.util.*;

public interface UserDao extends GenericDao<User, Long> {
	
	public User getUserByUsername(String username);
    public User getUserByEmail(String email);
	public Collection<User> findByFirstName(String firstName);
	public Collection<User> findByLastName(String lastName);
    
}
