package com.csu.library.mvc.dao;

import java.util.Collection;

import com.csu.library.mvc.beans.DisplayCurrentReservations;
import com.csu.library.mvc.dao.generic.GenericDao;
import com.csu.library.mvc.dto.*;

public interface ReservationDao extends GenericDao<Reservation, Long>{

	Collection<DisplayCurrentReservations> getReservationsByUserForDisplay(User user);

	Collection<Reservation> getReservationListByUser(User user);
	
}
