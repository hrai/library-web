package com.csu.library.mvc.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.csu.library.mvc.beans.UserLogin;
import com.csu.library.mvc.dto.Feedback;
import com.csu.library.mvc.dto.Fine;
import com.csu.library.mvc.dto.Loan;
import com.csu.library.mvc.dto.User;

@Transactional
public interface UserService {
	
	public User login(UserLogin userLogin);
	
	public Collection<Loan> getLoanedItems(long userId);
	
	public Fine calculateFine(Loan loan);
	
	public Collection<Feedback> getFeedbackList(User user);

	public void saveUser(User user);

	public void updateUser(User user);

	public User getUser(String username);

	public User getUser(Long id);

}
