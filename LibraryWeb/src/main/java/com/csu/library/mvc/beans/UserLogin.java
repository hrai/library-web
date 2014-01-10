package com.csu.library.mvc.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Repository;

@Repository
public class UserLogin {
	
	private String username;
	private String password;
	private String errorFindingUser;
	private boolean keepSignedIn;
	
	@NotNull
	@Size(min=1, message = "Enter your username.")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull
	@Size(min=1, message = "Enter your password.")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorFindingUser() {
		return errorFindingUser;
	}

	public void setErrorFindingUser(String errorFindingUser) {
		this.errorFindingUser = errorFindingUser;
	}
	
	public boolean isKeepSignedIn() {
		return keepSignedIn;
	}
	
	public void setKeepSignedIn(boolean keepSignedIn) {
		this.keepSignedIn = keepSignedIn;
	}

}
