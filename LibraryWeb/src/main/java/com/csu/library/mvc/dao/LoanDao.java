package com.csu.library.mvc.dao;

import java.util.Collection;

import com.csu.library.mvc.beans.DisplayCurrentLoans;
import com.csu.library.mvc.beans.DisplayAllLoanDetails;
import com.csu.library.mvc.dao.generic.GenericDao;
import com.csu.library.mvc.dto.*;

public interface LoanDao extends GenericDao<Loan, Long>{

	Loan getLoanByCatalogueEntryAndUser(long catalogueEntryId, int userId);

	Collection<DisplayCurrentLoans> getLoansByUserForDisplay(User user);

	Collection<Loan> getCurrentLoansByUser(User user);

	Collection<Loan> getLoansWithFines(User user);

	Collection<Loan> getLoansByUser(User user);

	Collection<DisplayAllLoanDetails> getLoanDetailsList(User user);
	
}
