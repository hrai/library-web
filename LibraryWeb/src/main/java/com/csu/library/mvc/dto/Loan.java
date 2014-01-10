package com.csu.library.mvc.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LOAN")
public class Loan implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long loanId;
	private Integer noOfRenewals;
	private Calendar dueDate;
	private Calendar outDate;
	private Calendar returnedDate;
	private Boolean overdue;
	private Collection<Fine> fines = new TreeSet<Fine>();
	private User user;
	private CatalogueEntry catalogueEntry;

	@Id
	@Column(name="loan_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	@Column(name="number_of_renewals")
	@NotNull
	public Integer getNoOfRenewals() {
		return noOfRenewals;
	}

	public void setNoOfRenewals(int noOfRenewals) {
		this.noOfRenewals = noOfRenewals;
	}

	@Column(name="due_date")
	@Temporal(TemporalType.DATE)
	//@Future
	@NotNull
	public Calendar getDueDate() {
		return dueDate;
	}

	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name="out_date")
	@Temporal(TemporalType.DATE)
	@NotNull
	public Calendar getOutDate() {
		return outDate;
	}

	public void setOutDate(Calendar outDate) {
		//System.out.println("out"+outDate.getTime());
		this.outDate = outDate;
	}

	@Column(name="returned_date")
	@Temporal(TemporalType.DATE)
	public Calendar getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Calendar returnedDate) {
		this.returnedDate = returnedDate;
	}

	@NotNull
	public Boolean isOverdue(Calendar currentDate) {
		if(currentDate.compareTo(dueDate) > 0) {
			overdue = true;
		}
		else {
			overdue = false;
		}

		return overdue;

	}

	public void setOverdue(Boolean status) {
		this.overdue = status;
	}

	@OneToMany(mappedBy="loan", cascade = CascadeType.PERSIST)
	@Valid
	public Collection<Fine> getFines() {
		return fines;
	}

	public void setFines(Collection<Fine> fines) {
		this.fines = fines;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_id")//, referencedColumnName="user_id", insertable=false, updatable=false)
	@Valid
	@NotNull
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="catalogue_entry_id")
	@Valid
	@NotNull
	public CatalogueEntry getCatalogueEntry() {
		return catalogueEntry;
	}

	public void setCatalogueEntry(CatalogueEntry catalogueEntry) {
		this.catalogueEntry = catalogueEntry;
	}

	public void addFine(Fine fine) {
		this.getFines().add(fine);
		fine.setLoan(this);
	}

	public void assignUser(User user) {
		if(user instanceof Professor) {
			this.setUser(user);
			((Professor) user).addLoan(this);
		}
		else if(user instanceof Student) {
			this.setUser(user);
			((Student) user).addLoan(this);
		}
	}

	public void assignCatalogueEntry(CatalogueEntry catalogueEntry) {
		this.catalogueEntry = catalogueEntry;
		catalogueEntry.addLoan(this);
	}
}
