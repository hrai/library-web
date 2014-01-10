package com.csu.library.mvc.beans;

import org.springframework.stereotype.Repository;

import com.csu.library.mvc.dto.Feedback;
import com.csu.library.mvc.dto.User;

@Repository
public class DisplayAllFeedback {

	private Feedback feedback;
	private User user;
	
	public Feedback getFeedback() {
		return feedback;
	}
	
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
