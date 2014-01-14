package com.csu.library.mvc.service.impl;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csu.library.mvc.dao.RoleDao;
import com.csu.library.mvc.dao.generic.GenericHibernateDao;
import com.csu.library.mvc.dto.Role;
import com.csu.library.mvc.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends GenericHibernateDao<Role, Long> implements RoleService {

	@Inject
	private RoleDao roleDao;
	
	@Override
	public Map<Long, String> getUserRolesList() {
		return roleDao.getRolesList();
	}
	
	@Override
	public Role getRoleById(Long roleId) {
		return roleDao.find(roleId, true);
	}
	
}
