package com.csu.library.mvc.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Scope("session")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator",
					discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "U")
@Table(name="USER")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String username;
	private String firstName;
	private String lastName;
	private Date DOB;
	private Address address;
	private String emailAddress;
	private String password;
	private Integer securityQuestion;
	private String securityAnswer;
	private Object photo;
	private Collection<Feedback> feedbackList = new TreeSet<Feedback>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name = "user_name", unique = true)
	@NotBlank
	@Size(min = 5, max = 20, message = "User ID must be 5 to 20 characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "User ID must be alphanumeric.")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "first_name")
	@NotBlank(message = "Enter your first name")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name")
	@NotBlank(message = "Enter your last name")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "date_of_birth")
	@NotNull(message = "Pick your date of birth")
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	public Date getDOB() {
		return DOB;
	}
	
	@Temporal(TemporalType.DATE)
	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	@NotNull
	@Embedded
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Column(name = "email_address", unique = true)
	@NotBlank(message = "Enter you email address")
	@Email
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Column(unique = true)
	@NotBlank
	@Size(min = 6, max = 20, message = "The password must be between 6 to 20 characters long.")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "security_question", unique = true)
	@NotNull(message = "Select a security question")
	public Integer getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(Integer securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	@Column(name = "security_password", unique = true)
	@NotBlank(message = "Enter your security answer")
	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	@Lob	//Saves a large object
	//@NotNull
	public Object getPhoto() {
		return photo;
	}

	public void setPhoto(Object photo) {
		this.photo = photo;
	}
	
	@OneToMany(mappedBy="user", cascade=CascadeType.PERSIST)
	public Collection<Feedback> getFeedbackList() {
		return feedbackList;
	}
	
	public void setFeedbackList(Collection<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}
	
	public void addFeedback(Feedback feedback) {
		this.feedbackList.add(feedback);
		feedback.setUser(this);
	}
}
