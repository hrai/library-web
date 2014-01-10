package com.csu.library.mvc.beans;

import java.util.Calendar;

import org.springframework.stereotype.Repository;

@Repository
public class DisplayCurrentLoans {
	
	Long loanId;
	String authors;
	String title;
	Integer yearPublished;
	Calendar outDate;
	Calendar dueDate;
	Boolean overdue;
	Integer noOfRenewals;
	Double amount;
	Long userId;
	
	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public String getAuthors() {
		return authors;
	}
	
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getYearPublished() {
		return yearPublished;
	}
	
	public void setYearPublished(Integer yearPublished) {
		this.yearPublished = yearPublished;
	}
	
	public Calendar getOutDate() {
		return outDate;
	}
	
	public void setOutDate(Calendar outDate) {
		this.outDate = outDate;
	}
	
	public Calendar getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}
	
	public Boolean getOverdue() {
		return overdue;
	}
	
	public void setOverdue(Boolean overdue) {
		this.overdue = overdue;
	}
	
	public Integer getNoOfRenewals() {
		return noOfRenewals;
	}
	
	public void setNoOfRenewals(Integer noOfRenewals) {
		this.noOfRenewals = noOfRenewals;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
