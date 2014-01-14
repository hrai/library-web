package com.csu.library.mvc.dao.implementation;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.csu.library.mvc.dao.RoleDao;
import com.csu.library.mvc.dao.generic.GenericHibernateDao;
import com.csu.library.mvc.dto.Role;

@Repository
public class RoleDaoImpl extends GenericHibernateDao<Role, Long> implements RoleDao {

	@Override
	public Map<Long, String> getRolesList() {
		Map<Long, String> mRoles = new TreeMap<>();
		
		for(Role role: findAll())
		{
			mRoles.put(role.getRoleId(), role.getAlias());
		}
		
		return mRoles;
	}

}
