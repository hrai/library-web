package com.csu.library.mvc.dao.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csu.library.mvc.dao.UserDao;
import com.csu.library.mvc.dao.generic.GenericHibernateDao;
import com.csu.library.mvc.dto.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends GenericHibernateDao<User, Long> implements UserDao {

	public User getUserByUsername(String username) {

		Criterion criterion = Restrictions.eq("username", username);
		Criteria criteria = (Criteria) getSessionFactory().getCurrentSession().createCriteria(User.class).add(criterion);

		User user = (User) criteria.uniqueResult();
		if(user == null)
			return null;

		return user;

	}

	public User getUserByEmail(String email) {
		try {
			Criterion criterion = Restrictions.eq("email", email);
			Criteria criteria = (Criteria) getSessionFactory().getCurrentSession().createCriteria(User.class).add(criterion);

			return (User) criteria.uniqueResult();
		}
		catch(NullPointerException ex) {
			return new User();
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> findByFirstName(String firstName) {
		Criterion criterion = Restrictions.eq("firstName", firstName);
		Criteria criteria = (Criteria) getSessionFactory().getCurrentSession().createCriteria(User.class).add(criterion);

		return (List<User>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<User> findByLastName(String lastName) {
		Criterion criterion = Restrictions.eq("lastName", lastName);
		Criteria criteria = (Criteria) getSessionFactory().getCurrentSession().createCriteria(User.class).add(criterion);

		return (List<User>) criteria.list();
	}

}
