package com.csu.library.mvc.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.inject.Inject;

import org.apache.commons.mail.EmailException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.csu.library.mvc.beans.DisplayCurrentLoans;
import com.csu.library.mvc.beans.DisplayAllLoanDetails;
import com.csu.library.mvc.dao.CatalogueEntryDao;
import com.csu.library.mvc.dao.FineDao;
import com.csu.library.mvc.dao.LoanDao;
import com.csu.library.mvc.dao.ReservationDao;
import com.csu.library.mvc.dao.StudentDao;
import com.csu.library.mvc.dao.UserDao;
import com.csu.library.mvc.dto.CatalogueEntry;
import com.csu.library.mvc.dto.Fine;
import com.csu.library.mvc.dto.Loan;
import com.csu.library.mvc.dto.Student;
import com.csu.library.mvc.dto.User;
import com.csu.library.mvc.helpers.EmailSenderService;
import com.csu.library.mvc.service.LoanService;
import com.csu.library.mvc.service.UserService;

@Service("loanService")
public class LoanServiceImpl implements LoanService {
	
	@Inject
	private LoanDao loanDao;
	@Inject
	private StudentDao studentDao;
	@Inject
	private FineDao fineDao;
	@Inject
	private UserService userService;
	@Inject
	private ReservationDao reservationDao;
	@Inject
	private CatalogueEntryDao catalogueEntryDao;
	@Inject
	private UserDao userDao;
	@Inject
	private EmailSenderService emailSenderService;
	
	/*
	@Async
	@Override
	public void sendEmail(Email email) throws EmailException {
		new EmailGenerator().createAndSendEmail(email);
	}
	*/

	public Loan getLoanById(Long loanId) {
		return loanDao.find(loanId, true);
	}

	@Async
	public void createLoan(CatalogueEntry catalogueEntry, User user) {
		Collection<Loan> loans = loanDao.getCurrentLoansByUser(userDao.find(user.getUserId(), true));
		Calendar currentCal = Calendar.getInstance();
		
		if(loans.size() >= 2) 
			return;
		else {
			for(Loan loan: loans) {
				if(loan.isOverdue(currentCal)) {
					return;
				}
				else if(loan.getNoOfRenewals() >= 2) {
					return;
				}
				else if(hasUnpaidFine(user)) {
					return;
				}
			}
		}

		Loan newLoan = new Loan();
		newLoan.setCatalogueEntry(catalogueEntry);
		newLoan.setOutDate((Calendar) currentCal.clone());
		Calendar dueDate = (Calendar) currentCal.clone();
		dueDate.add(Calendar.WEEK_OF_YEAR, 1);	//Rolling the calendar to a week further
		newLoan.setDueDate(dueDate);
		newLoan.setNoOfRenewals(0);
		newLoan.setUser(user);
		catalogueEntry.setLoaned(true);
		catalogueEntry.setAvailable(false);
		catalogueEntry.setLoanList(loanDao.getLoansByUser(user));
		catalogueEntry.addLoan(newLoan);
		
		loanDao.save(newLoan);
		catalogueEntryDao.update(catalogueEntry);
		
		try {
			emailSenderService.sendLoanEmail(user, newLoan);
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	
	@Async
	public void returnItem(Long loanId) {
		Loan loan = loanDao.find(loanId, true);//getLoanByCatalogueEntryAndUser(catalogueEntry.getCatalogueEntryId(), user.getUserID());
		Calendar currentCal = Calendar.getInstance();
		loan.setReturnedDate(currentCal);

		CatalogueEntry catalogueEntry = catalogueEntryDao.getCatalogueEntryByLoan(loan);
		if(loan.isOverdue(currentCal)) {
			Fine fine = userService.calculateFine(loan);
			Student student = studentDao.find(loan.getUser().getUserId(), true);//((Student) user).addFine(fine);
			loan.addFine(fine);
			
			catalogueEntry.setLoaned(false);
			if(!catalogueEntry.isReserved())
				catalogueEntry.setAvailable(true);
			
			fine.setStudent(student);
			fineDao.save(fine);
			studentDao.update(student);
		}
		loanDao.update(loan);
	}
	
	public boolean renewLoan(Loan loan, User user) {
		Calendar currentDate = Calendar.getInstance();
		
		if(!loan.isOverdue(currentDate)) {
			if(!hasUnpaidFine(user)) {
				if(loan.getNoOfRenewals() < 2) {
					if(reservationDao.getReservationListByUser(user).size() < 10) {
						int noOfRenewals = loan.getNoOfRenewals();
						
						currentDate.add(Calendar.WEEK_OF_YEAR, 1);
						
						loan.setDueDate(currentDate);
						loan.setNoOfRenewals(++noOfRenewals);
						
						loanDao.update(loan);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public Collection<DisplayCurrentLoans> getCurrentLoansForDisplay(User user) {
		return loanDao.getLoansByUserForDisplay(user);
	}
	
	public boolean hasUnpaidFine(User user) {
		Collection<Loan> loansWithFines = new ArrayList<Loan>();
		double dFine = 0;
		
		if(loansWithFines.isEmpty())
			return false;
		
		for(Loan loan: loansWithFines) {
			for(Fine fine: loan.getFines()) {
				dFine = fine.getAmount();
			}
		}
		
		return dFine>0?true:false;		
	}

	public Collection<DisplayAllLoanDetails> getLoanDetailsListForDisplay(User user) {
		return loanDao.getLoanDetailsList(user);
	}
	
}
