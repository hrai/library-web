package com.csu.library.mvc.dao;

import java.util.Collection;

import com.csu.library.mvc.beans.DisplayAllFeedback;
import com.csu.library.mvc.dao.generic.GenericDao;
import com.csu.library.mvc.dto.*;

public interface FeedbackDao extends GenericDao<Feedback, Long>{

	public Collection<Feedback> getFeedbackListByUser(User user);

	public Collection<DisplayAllFeedback> getFeedbackDisplayList();
	
}
