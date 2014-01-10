package com.csu.library.mvc.dto;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "FINE")
public class Fine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer fineID;
	private Double amount;
	private Calendar issueDate;
	private Loan loan;
	private CatalogueEntry catalogueEntry;
	private Student student;

	@Id
	@Column(name="fine_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getFineID() {
		return fineID;
	}
	
	public void setFineID(int fineID) {
		this.fineID = fineID;
	}
	
	@NotNull
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name="issue_date")
	@Temporal(TemporalType.DATE)
	@NotNull
	public Calendar getIssueDate() {
		return issueDate;
	}
	
	public void setIssueDate(Calendar issueDate) {
		this.issueDate = issueDate;
	}
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="loan_id")
	@NotNull
	@Valid
	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="catalogue_entry_id")
	@NotNull
	@Valid
	public CatalogueEntry getCatalogueEntry() {
		return catalogueEntry;
	}

	public void setCatalogueEntry(CatalogueEntry catalogueEntry) {
		this.catalogueEntry = catalogueEntry;
	}
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	@NotNull
	@Valid
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
