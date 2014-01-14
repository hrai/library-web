package com.csu.library.mvc.dao;

import java.util.Map;

import com.csu.library.mvc.dao.generic.GenericDao;
import com.csu.library.mvc.dto.Role;

public interface RoleDao extends GenericDao<Role, Long>{

	public Map<Long, String> getRolesList();

}
