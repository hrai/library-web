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
@Table(name = "RESERVATION")
public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer reservationID;
	private Calendar reservedDate;
	private User user;
	//private Email email;
	private CatalogueEntry catalogueEntry;
	
	@Id
	@Column(name = "reservation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getReservationID() {
		return reservationID;
	}
	
	public void setReservationID(Integer reservationID) {
		this.reservationID = reservationID;
	}
	
	@Column(name = "reserved_date")
	@Temporal(TemporalType.DATE)
	@NotNull
	public Calendar getReservedDate() {
		return reservedDate;
	}
	
	public void setReservedDate(Calendar reservedDate) {
		this.reservedDate = reservedDate;
	}
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	@Valid
	@NotNull
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/*
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinTable(name = "reservation_email", 
				joinColumns = @JoinColumn(name = "reservation_id"),
				inverseJoinColumns = @JoinColumn(name = "email_id"))
	@Valid
	@NotNull
	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}*/
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="catalogue_entry_id")
	@Valid
	@NotNull
	public CatalogueEntry getCatalogueEntry() {
		return catalogueEntry;
	}

	public void setCatalogueEntry(CatalogueEntry catalogueEntry) {
		this.catalogueEntry = catalogueEntry;
	}
	
	public void assignUser(User user) {
		this.user = user;
		user.addReservation(this);
	}
	
	public void assignCatalogueEntry(CatalogueEntry ctlgEntry) {
		this.catalogueEntry = ctlgEntry;
		ctlgEntry.addReservation(this);
	}
}
