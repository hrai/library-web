package com.csu.library.mvc.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Table(name="ROLE")
@Entity
public class Role implements Serializable, Comparable<Role> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long roleId;
	private String role;
	private String alias;
	private Collection<User> users = new TreeSet<>();

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id", nullable=false)
	public Long getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name="role")
	@NotEmpty
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USERROLE", 
					joinColumns={@JoinColumn(name="role_id")},
					inverseJoinColumns={@JoinColumn(name="user_id")})
	public Collection<User> getUsers() {
		return users;
	}
	
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	 
	public void addUser(User user)
	{
		this.getUsers().add(user);
		user.getRoles().add(this);
	}

	@NotEmpty
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public int compareTo(Role role) {
		return this.alias.compareTo(role.getAlias());
	}

}
