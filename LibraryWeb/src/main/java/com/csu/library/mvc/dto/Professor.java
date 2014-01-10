package com.csu.library.mvc.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;

@Scope("session")
@Entity
@DiscriminatorValue("P")
public class Professor extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer noOfLoans;
	private Integer noOfReservations;
	private Collection<Loan> loanList = new TreeSet<Loan>();
	//private boolean currentLoan;
	
	@Column(name="number_of_loans")
	@NotNull
	public Integer getNoOfLoans() {
		return noOfLoans;
	}
	
	public void setNoOfLoans(Integer noOfLoans) {
		this.noOfLoans = noOfLoans;
	}

	@Column(name="no_of_reservations")
	@NotNull
	public Integer getNoOfReservations() {
		return noOfReservations;
	}
	
	public void setNoOfReservations(int noOfReservations) {
		this.noOfReservations = noOfReservations;
	}
	
	@OneToMany(mappedBy="user", cascade=CascadeType.PERSIST)
	@Valid
	public Collection<Loan> getLoanList() {
		return loanList;
	}
	
	public void setLoanList(Collection<Loan> loanList) {
		this.loanList = loanList;
	}
	/*
	@Column(name="current_loan")
	@NotNull
	public boolean hasCurrentLoan() {
		return currentLoan;
	}

	public void setCurrentLoans(boolean currentLoan) {
		this.currentLoan = currentLoan;
	}
	*/
	public void addLoan(Loan loan) {
		this.getLoanList().add(loan);
		loan.setUser(this);
	}
	
	public void addProfessor(Loan loan) {
		this.getLoanList().add(loan);
		loan.setUser(this);
	}
}
