package com.csu.library.mvc.service.impl;

import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csu.library.mvc.beans.UserLogin;
import com.csu.library.mvc.dao.CatalogueEntryDao;
import com.csu.library.mvc.dao.FineDao;
import com.csu.library.mvc.dao.LoanDao;
import com.csu.library.mvc.dao.UserDao;
import com.csu.library.mvc.dto.Feedback;
import com.csu.library.mvc.dto.Fine;
import com.csu.library.mvc.dto.Loan;
import com.csu.library.mvc.dto.User;
import com.csu.library.mvc.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDao userDao;
	@Inject
	private CatalogueEntryDao catalogueEntryDao;
	@Inject
	private FineDao fineDao;
	@Inject
	private LoanDao loanDao;
	
	public User getUser(Long id) {
		return userDao.find(id, true);
	}
	
	public User getUser(String username) {
		return userDao.getUserByUsername(username);		 
	}

	public User login(UserLogin userLogin) {
		User userDB = getUser(userLogin.getUsername());
		
		return userDB;
		//if(userDB!=null)
			//return checkUsernameAndPassword(userLogin, userDB)==true?userDB:null;
		
		//return null;
	}
	
	public Collection<Loan> getLoanedItems(long userId) {
		return loanDao.getCurrentLoansByUser(userDao.find(userId, true));
	}

	public Fine calculateFine(Loan loan) {
		Fine fine = new Fine();
		int today = Calendar.DAY_OF_YEAR;

		double amount = -1 * (today - loan.getDueDate().get(Calendar.DAY_OF_YEAR)) * 1.5;
		fine.setCatalogueEntry(catalogueEntryDao.getCatalogueEntryByLoan(loan));
		fine.setIssueDate(Calendar.getInstance());
		fine.setLoan(loan);		
		fine.setAmount(amount);
		
		return fine;
	}

	public Collection<Feedback> getFeedbackList(User user) {
		return user.getFeedbackList();
	}

	public void saveUser(User user) {
		userDao.save(user);
	}
	
	public void updateUser(User user) {
		userDao.update(user);
	}
	
	/**
	 * Check if user1 is equal to user2 in terms of username and password
	 * 
	 * @param userLogin
	 * @param user
	 * @return true if both username and password are equal else return false
	 */
	private boolean checkUsernameAndPassword(UserLogin userLogin, User user) {
		String usernameLogin = userLogin.getUsername();
		String username = user.getUsername();
		String passwordLogin = userLogin.getPassword();
		String password = user.getPassword();
		
		if(usernameLogin.trim().toLowerCase().equals(username.trim().toLowerCase())) {
			if(passwordLogin.trim().equals(password.trim())) {
				return true;
			}
		}
		
		return false;
	}

}
