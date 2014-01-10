package com.csu.library.mvc.controller;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.csu.library.mvc.beans.DisplayAllLoanDetails;
import com.csu.library.mvc.dto.CatalogueEntry;
import com.csu.library.mvc.dto.Loan;
import com.csu.library.mvc.dto.User;
import com.csu.library.mvc.service.CatalogueEntryService;
import com.csu.library.mvc.service.LoanService;
import com.csu.library.mvc.service.UserService;

@SessionAttributes({"user"})
@Controller
public class LoanController {
	
	@Inject
	LoanService loanService;
	@Inject
	CatalogueEntryService catalogueEntryService;
	@Inject
	UserService userService;
	
	@RequestMapping(value="/display_loans")
	public String loanList(@ModelAttribute User user, Model model) {
		Collection<DisplayAllLoanDetails>loanDetailsList = loanService.getLoanDetailsListForDisplay(user);		
		model.addAttribute("loanDetailsList", loanDetailsList);

		return "/allLoans";
	}
	
	@RequestMapping(value="/loan_item/{barcode}/{userID}", method=RequestMethod.GET)
	public String loanItem(@PathVariable Long userID, @PathVariable Long barcode) {
		CatalogueEntry catalogueEntry = catalogueEntryService.getItemByBarcode(barcode);
		User user = userService.getUser(userID);
		
		loanService.createLoan(catalogueEntry, user);
		
		return "/homepage";
	}
	
	@RequestMapping(value="/return_item/{loanId}", method=RequestMethod.GET)
	public String returnLoanItem(@PathVariable Long loanId) {
		loanService.returnItem(loanId);
		
		return "/homepage";
	}

	@RequestMapping(value="/renew_item/{loanId}/{userId}", method=RequestMethod.GET)
	public String renewLoan(@PathVariable Long loanId, @PathVariable Long userId) {
		Loan loan = loanService.getLoanById(loanId);
		User user = userService.getUser(userId);
		
		if(loan == null || user == null) {
			throw new NullPointerException();
		}
		
		loanService.renewLoan(loan, user);
		
		return "/homepage";
	}
	
	

}
