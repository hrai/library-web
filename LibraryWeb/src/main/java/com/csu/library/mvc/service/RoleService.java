package com.csu.library.mvc.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.csu.library.mvc.dao.generic.GenericDao;
import com.csu.library.mvc.dto.Role;

@Transactional
public interface RoleService extends GenericDao<Role, Long> {

	public Map<Long, String> getUserRolesList();

	public Role getRoleById(Long roleId);

}
