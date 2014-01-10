package com.csu.library.mvc.dao.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.csu.library.mvc.beans.DisplayCurrentLoans;
import com.csu.library.mvc.beans.DisplayAllLoanDetails;
import com.csu.library.mvc.dao.LoanDao;
import com.csu.library.mvc.dao.generic.GenericHibernateDao;
import com.csu.library.mvc.dto.Fine;
import com.csu.library.mvc.dto.Loan;
import com.csu.library.mvc.dto.User;

@Repository("loanDao")
public class LoanDaoImpl extends GenericHibernateDao<Loan, Long> implements LoanDao {

	public Loan getLoanByCatalogueEntryAndUser(long catalogueEntryId, int userId) {

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass());
		Criterion criterion1 = Restrictions.eq("catalogueEntryId", catalogueEntryId);
		Criterion criterion2 = Restrictions.eq("userId", userId);
		criteria.add(criterion1).add(criterion2);

		return (Loan) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public Collection<Loan> getCurrentLoansByUser(User user) {

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass());
		Criterion criterion = Restrictions.eq("user", user);
		Criterion criterion2 = Restrictions.isNull("returnedDate");
		criteria.add(criterion).add(criterion2);

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public Collection<Loan> getLoansWithFines(User user) {

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass());
		Criterion criterion = Restrictions.eq("user", user);
		Criterion criterion2 = Restrictions.isNotNull("fines");
		criteria.add(criterion).add(criterion2);

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public Collection<DisplayCurrentLoans> getLoansByUserForDisplay(User user) {

		ArrayList<DisplayCurrentLoans> currentDisplayLoans = new ArrayList<DisplayCurrentLoans>();

		String hqlQuery = "select loan from Loan loan " + 
				"left join fetch loan.user user " + 
				"left join fetch loan.catalogueEntry catalogueEntry " + 
				"left join fetch loan.fines fines " + 
				"where loan.user.userId = :userId " +
				"order by loan.loanId";

		Query query = getSessionFactory().getCurrentSession().createQuery(hqlQuery);
		query.setParameter("userId", user.getUserId());
		List<Object> list =  query.list();
		Iterator<Object> iter = list.iterator();

		while(iter.hasNext()) {
			DisplayCurrentLoans currentLoan = new DisplayCurrentLoans();
			Loan obj = (Loan) iter.next();

			//if the loan is active
			if(obj.getReturnedDate() == null) {
				currentLoan.setLoanId(obj.getLoanId());
				currentLoan.setAuthors(obj.getCatalogueEntry().getAuthors());
				currentLoan.setTitle(obj.getCatalogueEntry().getTitle());
				currentLoan.setYearPublished(obj.getCatalogueEntry().getYearPublished());
				currentLoan.setOutDate(obj.getOutDate());
				currentLoan.setDueDate(obj.getDueDate());
				currentLoan.setNoOfRenewals(obj.getNoOfRenewals());
				currentLoan.setUserId(user.getUserId());

				double fineAmount = 0;
				Collection<Fine> fines = obj.getFines();
				for(Fine f: fines) 
					fineAmount+= f.getAmount();
				currentLoan.setAmount(fineAmount);

				currentDisplayLoans.add(currentLoan);
			}
		}

		return currentDisplayLoans;

	}

	@SuppressWarnings("unchecked")
	public Collection<Loan> getLoansByUser(User user) {
		Criterion criterion = Restrictions.eq("user", user);
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass());
		criteria.add(criterion);

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public Collection<DisplayAllLoanDetails> getLoanDetailsList(User user) {

		ArrayList<DisplayAllLoanDetails> allLoansList = new ArrayList<DisplayAllLoanDetails>();

		String hqlQuery = "select loan from Loan loan " + 
				"left join fetch loan.user user " + 
				"left join fetch loan.catalogueEntry catalogueEntry " + 
				"left join fetch loan.fines fines " + 
				"where loan.user.userId = :userId " +
				"order by loan.loanId";

		Query query = getSessionFactory().getCurrentSession().createQuery(hqlQuery);
		query.setParameter("userId", user.getUserId());
		List<Object> list =  query.list();
		Iterator<Object> iter = list.iterator();

		while(iter.hasNext()) {
			DisplayAllLoanDetails loan = new DisplayAllLoanDetails();
			Loan obj = (Loan) iter.next();
			
			loan.setCatalogueEntry(obj.getCatalogueEntry());
			loan.setLoan(obj);

			double fineAmount = 0;
			Collection<Fine> fines = obj.getFines();
			for(Fine f: fines) 
				fineAmount+= f.getAmount();
			loan.setFine(fineAmount);

			allLoansList.add(loan);

		}

		return allLoansList;

	}
}
