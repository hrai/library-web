package com.csu.library.mvc.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.csu.library.mvc.beans.DisplayCurrentReservations;
import com.csu.library.mvc.dto.CatalogueEntry;
import com.csu.library.mvc.dto.User;

@Transactional
public interface ReservationService {
	
	public Collection<DisplayCurrentReservations> getAvailableReservations(User user);
	public void cancelReservation(Long reservationId);
	public boolean reserveItem(CatalogueEntry catalogueEntry, User user);

}
