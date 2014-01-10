package com.csu.library.mvc.dao.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.csu.library.mvc.beans.DisplayAllFeedback;
import com.csu.library.mvc.dao.FeedbackDao;
import com.csu.library.mvc.dao.generic.GenericHibernateDao;
import com.csu.library.mvc.dto.Feedback;
import com.csu.library.mvc.dto.User;

@Repository("feedbackDao")
public class FeedbackDaoImpl extends GenericHibernateDao<Feedback, Long> implements FeedbackDao {

	@SuppressWarnings("unchecked")
	public Collection<Feedback> getFeedbackListByUser(User user) {
		String hqlQuery = "select feedback from Feedback feedback where feedback.user.userId = :userId";
		Query query = getSessionFactory().getCurrentSession().createQuery(hqlQuery);
		query.setParameter("userId", user.getUserId());

		return query.list();

	}

	@SuppressWarnings("unchecked")
	public Collection<DisplayAllFeedback> getFeedbackDisplayList() {
		Collection<DisplayAllFeedback> displayFeedbackList = new ArrayList<DisplayAllFeedback>();

		String hqlQuery = "select feedback from Feedback feedback " + 
				"left join fetch feedback.user user";

		Query query = getSessionFactory().getCurrentSession().createQuery(hqlQuery);
		List<Object> list =  query.list();
		Iterator<Object> iter = list.iterator();

		while(iter.hasNext()) {
			DisplayAllFeedback displayFeedback = new DisplayAllFeedback();
			Feedback obj = (Feedback) iter.next();

			displayFeedback.setFeedback(obj);
			displayFeedback.setUser(obj.getUser());

			displayFeedbackList.add(displayFeedback);
		}

		return displayFeedbackList;
	}

}
