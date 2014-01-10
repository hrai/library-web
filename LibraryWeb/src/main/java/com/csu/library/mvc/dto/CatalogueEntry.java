package com.csu.library.mvc.dto;

import java.io.Serializable;
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
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="CATALOGUE_ENTRY")
public class CatalogueEntry implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer catalogueEntryId;
	private Long barcode;
	private Integer yearPublished;
	private String title;
	private String publisher;
	private String isbn;
	private String countryOfPublication;
	private Boolean reserved;
	private Boolean loaned;
	private Boolean available;
	private User librarian;
	private String authors;
	private Collection<Fine> fines = new TreeSet<Fine>();
	private Collection<Reservation> reservationList = new TreeSet<Reservation>();
	private Collection<Loan> loanList = new TreeSet<Loan>();

	@Id
	@Column(name="catalogue_entry_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCatalogueEntryId() {
		return catalogueEntryId;
	}
	
	public void setCatalogueEntryId(Integer catalogueEntryId) {
		this.catalogueEntryId = catalogueEntryId;
	}
	
	@NotNull
	@Column(unique=true)
	public Long getBarcode() {
		return barcode;
	}

	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}

	@Column(name="year_published")
	@NotNull
	public Integer getYearPublished() {
		return yearPublished;
	}
	
	public void setYearPublished(Integer yearPublished) {
		this.yearPublished = yearPublished;
	}
	
	@NotBlank
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@NotBlank
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@NotBlank
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@NotBlank
	@Column(name="country_of_publication")
	public String getCountryOfPublication() {
		return countryOfPublication;
	}

	public void setCountryOfPublication(String countryOfPublication) {
		this.countryOfPublication = countryOfPublication;
	}

	@NotNull
	public Boolean isReserved() {
		return reserved;
	}
	
	public void setReserved(Boolean status) {
		reserved = status;
	}
	
	@NotNull
	public Boolean isLoaned() {
		return loaned;
	}
	
	public void setLoaned(Boolean loaned) {
		this.loaned = loaned;
	}
	
	@NotNull
	public Boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(Boolean status) {
		available = status;
	}
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	@NotNull
	@Valid
	public User getLibrarian() {
		return librarian;
	}
	
	public void setLibrarian(User librarian) {
		this.librarian = librarian;
	}
	
	@NotBlank
	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	@OneToMany(mappedBy="catalogueEntry", cascade=CascadeType.PERSIST)
	@Valid
	public Collection<Fine> getFines() {
		return fines;
	}

	public void setFines(Collection<Fine> fines) {
		this.fines = fines;
	}

	public void addFine(Fine fine) {
		this.getFines().add(fine);
		fine.setCatalogueEntry(this);
	}
	
	/*
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "catalogue_entry_author",
				joinColumns = @JoinColumn(name = "catalogue_entry_id"),
				inverseJoinColumns = @JoinColumn(name = "author_id"))
	@NotEmpty
	@Valid
	public Collection<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(Collection<Author> authorList) {
		this.authorList = authorList;
	}
	
	public void addAuthor(Author author) {
		this.getAuthorList().add(author);
		author.getCatalogueEntryList().add(this);
	}
	*/
	
	@OneToMany(mappedBy="catalogueEntry", cascade=CascadeType.PERSIST)
	@Valid
	public Collection<Loan> getLoanList() {
		return loanList;
	}

	public void setLoanList(Collection<Loan> loanList) {
		this.loanList = loanList;
	}
	
	public void addLoan(Loan loan) {
		this.getLoanList().add(loan);
		loan.setCatalogueEntry(this);
	}
	
	@OneToMany(mappedBy="catalogueEntry", cascade = CascadeType.PERSIST)
	@Valid
	public Collection<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(Collection<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
	
	public void addReservation(Reservation reservation) {
		this.getReservationList().add(reservation);
		reservation.setCatalogueEntry(this);
	}
}
