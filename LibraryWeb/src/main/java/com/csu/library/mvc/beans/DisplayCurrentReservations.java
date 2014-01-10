package com.csu.library.mvc.beans;

import java.util.Calendar;

import org.springframework.stereotype.Repository;

@Repository
public class DisplayCurrentReservations {

	private String authors;
	private Calendar reservedDate;
	private String catalogueEntryName;
	private Long barcode;
	private Long userId;
	
	public String getAuthors() {
		return authors;
	}
	
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	public Calendar getReservedDate() {
		return reservedDate;
	}
	
	public void setReservedDate(Calendar reservedDate) {
		this.reservedDate = reservedDate;
	}
	
	public String getCatalogueEntryName() {
		return catalogueEntryName;
	}
	
	public void setCatalogueEntryName(String catalogueEntryName) {
		this.catalogueEntryName = catalogueEntryName;
	}

	public Long getBarcode() {
		return barcode;
	}

	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
