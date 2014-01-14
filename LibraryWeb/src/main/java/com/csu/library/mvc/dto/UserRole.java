/*package com.csu.library.mvc.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USERROLE")
public class UserRole {

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="role_id")
	private Long roleId;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	private Long userId;
	
	public Long getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
*/