package com.csu.library.mvc.helpers;

import java.util.Calendar;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import com.csu.library.mvc.dto.Loan;
import com.csu.library.mvc.dto.Reservation;
import com.csu.library.mvc.dto.User;

@Service
public class EmailSenderService {
	
	public void sendLoanEmail(User user, Loan loan) throws EmailException {
		SimpleEmail email = new SimpleEmail();
		String username = "com.csu.library";
		String password = "com csu library";
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthentication(username, password);
		email.setSSLOnConnect(true);
		email.setFrom("no-reply@library.csu.edu.au", "CSU Library Automated System");
		email.setSubject("Loan Issued");
		email.setMsg("Dear " + user.getFirstName() + " " + user.getLastName() + ",");
		email.setMsg("You have been loaned a book. The due date of the book is " + loan.getDueDate().getTime().toString() + ".");
		email.setMsg("Regards,");
		email.setMsg("CSU Library Team");
		email.addTo(user.getEmailAddress());
		email.send();
	}
	
	public void sendReservationEmail(User user, Reservation reservation) throws EmailException {
		SimpleEmail email = new SimpleEmail();
		String username = "com.csu.library";
		String password = "com csu library";
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthentication(username, password);
		email.setSSLOnConnect(true);
		email.setFrom("no-reply@library.csu.edu.au", "CSU Library Automated System");
		email.setSubject("Reservation Confirmed");
		email.setMsg("Dear " + user.getFirstName() + " " + user.getLastName() + ",");
		email.setMsg("You have booked an item. Your reservation reference number is " + Calendar.getInstance().getTime().toString() + ".");
		email.setMsg("Regards,");
		email.setMsg("CSU Library Team");
		email.addTo(user.getEmailAddress());
		email.send();
	}
}
