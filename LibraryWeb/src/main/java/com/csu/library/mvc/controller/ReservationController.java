package com.csu.library.mvc.controller;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.csu.library.mvc.beans.DisplayCurrentReservations;
import com.csu.library.mvc.dto.User;
import com.csu.library.mvc.service.CatalogueEntryService;
import com.csu.library.mvc.service.ReservationService;
import com.csu.library.mvc.service.UserService;

@SessionAttributes("user")
@Controller
public class ReservationController {
	
	@Inject
	private ReservationService reservationService;
	@Inject
	private CatalogueEntryService catalogueEntryService;
	@Inject
	private UserService userService;
	
	@RequestMapping(value="/reserve_item/{barcode}/{userID}")
	public String reserveItem(@PathVariable Long barcode, @PathVariable Long userID) {
		reservationService.reserveItem(catalogueEntryService.getItemByBarcode(barcode), userService.getUser(userID));
		
		return "/homepage";
	}
	
	@RequestMapping(value="/display_reservations")
	public String displayCurrentReservations(@ModelAttribute(value="user") User user, Model model) {
		Collection<DisplayCurrentReservations> currentReservations = reservationService.getAvailableReservations(user);
		model.addAttribute("currentReservations", currentReservations);
		
		return "/currentReservations";
	}
	
}
