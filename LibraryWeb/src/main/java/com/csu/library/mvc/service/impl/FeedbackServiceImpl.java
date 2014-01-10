package com.csu.library.mvc.service.impl;

import java.util.Calendar;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csu.library.mvc.beans.DisplayAllFeedback;
import com.csu.library.mvc.dao.FeedbackDao;
import com.csu.library.mvc.dao.UserDao;
import com.csu.library.mvc.dto.Feedback;
import com.csu.library.mvc.dto.User;
import com.csu.library.mvc.service.FeedbackService;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

	@Inject
	FeedbackDao feedbackDao;
	@Inject
	UserDao userDao;
	
	public void saveFeedback(Feedback feedback, User user) {
		feedback.setCreatedDate(Calendar.getInstance());
		user.setFeedbackList(feedbackDao.getFeedbackListByUser(user));
		user.addFeedback(feedback);
		
		feedbackDao.save(feedback);
		userDao.update(user);		
	}

	public Collection<DisplayAllFeedback> getFeedbackDisplayList() {
		return feedbackDao.getFeedbackDisplayList();
	}
	
}
