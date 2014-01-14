/*package com.csu.library.mvc.dto;

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
@DiscriminatorValue("S")
public class Student extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer noOfLoans;
	private Integer noOfReservations;
	private Boolean currentLoan;
	private Boolean unpaidFine;
	private Collection<Loan> loanList = new TreeSet<Loan>();
	private Collection<Reservation> reservationList = new TreeSet<Reservation>();
	private Collection<Fine> fineList = new TreeSet<Fine>();
	
	@Column(name="number_of_loans")
	@NotNull
	public Integer getNoOfLoans() {
		return noOfLoans;
	}
	
	public void setNoOfLoans(int noOfLoans) {
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
	
	@Column(name="current_loan")
	@NotNull
	public Boolean hasCurrentLoan() {
		return currentLoan;
	}

	public void setCurrentLoans(boolean currentLoan) {
		this.currentLoan = currentLoan;
	}
	
	@Column(name="unpaid_fine")
	@NotNull
	public Boolean hasUnpaidFine() {
		return unpaidFine;
	}

	public void setUnpaidFine(boolean unpaidFine) {
		this.unpaidFine = unpaidFine;
	}
	
	@OneToMany(mappedBy="user", cascade=CascadeType.PERSIST)
	@Valid
	public Collection<Loan> getLoanList() {
		return loanList;
	}
	
	public void setLoanList(Collection<Loan> loanList) {
		this.loanList = loanList;
	}
	
	@OneToMany(mappedBy="student", cascade=CascadeType.PERSIST)
	@Valid
	public Collection<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(Collection<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
	
	@OneToMany(mappedBy="student", cascade = CascadeType.PERSIST)
	@Valid
	public Collection<Fine> getFineList() {
		return fineList;
	}

	public void setFineList(Collection<Fine> fineList) {
		this.fineList = fineList;
	}
	
	public void addLoan(Loan loan) {
		this.noOfLoans++;
		//this.currentLoan = true;
		this.getLoanList().add(loan);
		loan.setUser(this);
	}
	
	public void addReservation(Reservation reservation) {
		this.noOfReservations++;
		this.getReservationList().add(reservation);
		reservation.setStudent(this);
	}
	
	public void addFine(Fine fine) {
		//this.unpaidFine = true;
		this.getFineList().add(fine);
		fine.setStudent(this);
	}

}
*/