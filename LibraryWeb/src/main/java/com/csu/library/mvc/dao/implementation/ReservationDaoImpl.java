package com.csu.library.mvc.dao.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import org.springframework.stereotype.Repository;

import com.csu.library.mvc.beans.DisplayCurrentReservations;
import com.csu.library.mvc.dao.ReservationDao;
import com.csu.library.mvc.dao.generic.GenericHibernateDao;
import com.csu.library.mvc.dto.Reservation;
import com.csu.library.mvc.dto.User;

@Repository("reservationDao")
public class ReservationDaoImpl extends GenericHibernateDao<Reservation, Long> implements ReservationDao {

	@SuppressWarnings("unchecked")
	public Collection<DisplayCurrentReservations> getReservationsByUserForDisplay(
			User user) {
		Collection<DisplayCurrentReservations> currentDisplayReservations = new ArrayList<DisplayCurrentReservations>();

		String hqlQuery = "select reservation from Reservation reservation " +
				"left join fetch reservation.catalogueEntry catalogueEntry " +
				"where reservation.student.userId = :userId";
		Query query = getSessionFactory().getCurrentSession().createQuery(hqlQuery);
		query.setParameter("userId", user.getUserId());
		List<Object> list = query.list();
		Iterator<Object> iter = list.iterator();

		while(iter.hasNext()) {
			DisplayCurrentReservations cur = new DisplayCurrentReservations();
			Reservation obj = (Reservation) iter.next();

			cur.setCatalogueEntryName(obj.getCatalogueEntry().getTitle());
			cur.setAuthors(obj.getCatalogueEntry().getAuthors());
			cur.setReservedDate(obj.getReservedDate());
			cur.setBarcode(obj.getCatalogueEntry().getBarcode());
			cur.setUserId(user.getUserId());

			currentDisplayReservations.add(cur);
		}

		return currentDisplayReservations;
	}

	@SuppressWarnings("unchecked")
	public Collection<Reservation> getReservationListByUser(User user) {
		String hqlQuery = "select reservation from Reservation reservation where reservation.student.userId = :userId";
		Query query = getSessionFactory().getCurrentSession().createQuery(hqlQuery);
		query.setParameter("userId", user.getUserId());
		
		return query.list();
	}

}
