package com.csu.library.mvc.beans;

import org.springframework.stereotype.Repository;

import com.csu.library.mvc.dto.CatalogueEntry;
import com.csu.library.mvc.dto.Loan;

@Repository
public class DisplayAllLoanDetails {
	
	private CatalogueEntry catalogueEntry;
	private Loan loan;
	private double fine;
	
	public CatalogueEntry getCatalogueEntry() {
		return catalogueEntry;
	}
	
	public void setCatalogueEntry(CatalogueEntry catalogueEntry) {
		this.catalogueEntry = catalogueEntry;
	}
	
	public Loan getLoan() {
		return loan;
	}
	
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	
	public double getFine() {
		return fine;
	}
	
	public void setFine(double fine) {
		this.fine = fine;
	}
		
}
