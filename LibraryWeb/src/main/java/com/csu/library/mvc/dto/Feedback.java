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

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "FEEDBACK")
public class Feedback implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer feedbackID;
	private String subject;
	private String message;
	private Calendar createdDate;
	private User user;
	
	@Id
	@Column(name="feedback_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getFeedbackID() {
		return feedbackID;
	}
	
	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}
	
	@NotBlank
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@NotBlank
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name="created_date")
	@Temporal(TemporalType.DATE)
	@NotNull
	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	@NotNull
	@Valid
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
