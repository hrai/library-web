package com.csu.library.mvc.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.csu.library.mvc.beans.DisplayAllFeedback;
import com.csu.library.mvc.dto.Feedback;
import com.csu.library.mvc.dto.User;

@Transactional
public interface FeedbackService {
	
	void saveFeedback(Feedback feedback, User user);

	public Collection<DisplayAllFeedback> getFeedbackDisplayList();

}
