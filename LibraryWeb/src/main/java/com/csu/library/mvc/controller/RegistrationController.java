package com.csu.library.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csu.library.mvc.dto.User;
import com.csu.library.mvc.service.RoleService;
import com.csu.library.mvc.service.UserService;

@Controller
public class RegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Inject
	RoleService roleService;
	@Inject
	UserService userService;
	
	@ModelAttribute(value = "userTypes")
	public Map<Long, String> userTypeModelAttribute() {
		return roleService.getUserRolesList();
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET) 
	public String registrationPage(Model model) {
		model.addAttribute("user", new User());

		return "/registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveNewUser(@Valid User user, BindingResult bindingResult, Model model) {
			//, @RequestParam Long roleId) {

		if(bindingResult.hasErrors()) {
			for(FieldError e : bindingResult.getFieldErrors()) {
				logger.error(e.getField());
			}

			return "/registration";
		}

		user.setEnabled(true);
		user.setNoOfLoans(0);
		user.setNoOfReservations(0);
		user.setCurrentLoans(false);
		user.setUnpaidFine(false);
		user.addRole(roleService.getRoleById(user.getLastAddedRoleId()));
		
		userService.saveUser(user); 
		
		model.addAttribute("user", userService.getUser(user.getUsername()));
		
		return "/homepage";
	}

	@ModelAttribute(value = "securityQuestions")
	public static Map<Integer, String> securityQuestionsModelAttribute() {
		Map<Integer, String> questions = new HashMap<Integer, String>();
		questions.put(0, "Select your security question");
		questions.put(1, "What was your first pet?");
		questions.put(2, "What is your mother's maiden name?");
		questions.put(3, "What is your spouse's name?");
		questions.put(4, "What is your best friend's name?");

		return questions;
	}

	@ModelAttribute(value = "states")
	public Map<String, String> statesModelAttribute() {
		Map<String, String> states = new HashMap<String, String>();
		states.put("NSW", "NSW");
		states.put("NT", "NT");
		states.put("QLD", "QLD");
		states.put("SA", "SA");
		states.put("TAS", "TAS");
		states.put("VIC", "VIC");
		states.put("WA", "WA");

		return states;
	}

}
