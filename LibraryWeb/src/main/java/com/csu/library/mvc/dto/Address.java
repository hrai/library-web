package com.csu.library.mvc.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer unit;
	private Integer streetNumber;
	private String streetName;
	private String suburb;
	private String state;
	private Integer postcode;
	
	@Column(name="unit_number")
	public Integer getUnit() {
		return unit;
	}
	
	public void setUnit(Integer unit) {
		this.unit = unit;
	}
	
	@Column(name="street_number", nullable=false)
	@NotNull(message = "Enter your street number")
	public Integer getStreetNumber() {
		return streetNumber;
	}
	
	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	@Column(name="street_name", nullable=false)
	@NotBlank(message = "Enter your street name")
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	@Column(name="suburb_name", nullable=false)
	@NotBlank(message = "Enter your suburb")
	public String getSuburb() {
		return suburb;
	}
	
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	
	@Column(name="state_name", nullable=false)
	@NotBlank(message = "Pick your state")
	//@Size(max = 3, min = 2, message = "The state code must be between 2 to 3 characters.")
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(nullable=false)
	@NotNull(message = "Enter your postcode")
	//@Size(min = 1000, max = 9999, message = "The postcode must be 4 characters long.")	//Specific to Australia
	public Integer getPostcode() {
		return postcode;
	}
	
	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}
	
	
}
