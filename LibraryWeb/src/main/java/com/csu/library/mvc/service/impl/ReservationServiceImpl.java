package com.csu.library.mvc.service.impl;

import java.util.Calendar;
import java.util.Collection;

import javax.inject.Inject;

import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Service;

import com.csu.library.mvc.beans.DisplayCurrentReservations;
import com.csu.library.mvc.dao.CatalogueEntryDao;
import com.csu.library.mvc.dao.ReservationDao;
import com.csu.library.mvc.dto.CatalogueEntry;
import com.csu.library.mvc.dto.Reservation;
import com.csu.library.mvc.dto.Student;
import com.csu.library.mvc.dto.User;
import com.csu.library.mvc.helpers.EmailSenderService;
import com.csu.library.mvc.service.LoanService;
import com.csu.library.mvc.service.ReservationService;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {

	@Inject
	ReservationDao reservationDao;
	@Inject
	CatalogueEntryDao catalogueEntryDao;
	@Inject
	LoanService loanService;
	@Inject
	EmailSenderService emailSenderService;
	
	public Collection<DisplayCurrentReservations> getAvailableReservations(User user) {
		return reservationDao.getReservationsByUserForDisplay(user);
	}

	public void cancelReservation(Long reservationId) {
		Reservation reservation = reservationDao.find(reservationId, true);
		reservationDao.delete(reservation);
	}	

	public boolean reserveItem(CatalogueEntry catalogueEntry, User user) {
		if(catalogueEntry.isAvailable()) {
			if(!loanService.hasUnpaidFine(user)) {
				if(((Student)user).getNoOfLoans() < 2) {
					Reservation reservation = new Reservation();
					reservation.setCatalogueEntry(catalogueEntry);
					reservation.setReservedDate(Calendar.getInstance());
					reservation.setStudent((Student) user);
					
					catalogueEntry.setReserved(true);
					catalogueEntry.setAvailable(false);
					catalogueEntry.setReservationList(reservationDao.getReservationListByUser(user));
					catalogueEntry.addReservation(reservation);
					
					reservationDao.save(reservation);					
					catalogueEntryDao.update(catalogueEntry);
					
					try {
						emailSenderService.sendReservationEmail(user, reservation);
					} catch (EmailException e) {
						e.printStackTrace();
					}
					return true;
				}
			}
		}
		
		return false;
	}


}
