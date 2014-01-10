package com.csu.library.mvc.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.csu.library.mvc.beans.DisplayCurrentLoans;
import com.csu.library.mvc.beans.DisplayAllLoanDetails;
import com.csu.library.mvc.dto.CatalogueEntry;
import com.csu.library.mvc.dto.Loan;
import com.csu.library.mvc.dto.User;

@Transactional
public interface LoanService {
	
	public void createLoan(CatalogueEntry ctlgEntry, User user);
	
	public void returnItem(Long loanId);

	public boolean renewLoan(Loan loan, User user);

	public Collection<DisplayCurrentLoans> getCurrentLoansForDisplay(User user);

	public Loan getLoanById(Long loanId);

	boolean hasUnpaidFine(User user);

	public Collection<DisplayAllLoanDetails> getLoanDetailsListForDisplay(User user);
}
