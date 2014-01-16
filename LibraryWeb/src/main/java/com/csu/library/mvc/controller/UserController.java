package com.csu.library.mvc.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.csu.library.mvc.dto.User;
import com.csu.library.mvc.service.UserService;

@SessionAttributes({"searchOptions", "search", "user"})
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService userService;

	@RequestMapping(value="/edit_user_details", method = RequestMethod.GET)
	public String editUserDetails(@ModelAttribute User user, Model model) {
		model.addAttribute("securityQuestions", RegistrationController.securityQuestionsModelAttribute());

		return "/editUserInfo";
	}

	@RequestMapping(value="/update_user_details", method = RequestMethod.POST) 
	public String updateUserDetails(@Valid @ModelAttribute User editableUser, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "/editUserInfo";

		userService.updateUser(editableUser);
		logger.info(editableUser.getUsername() + "'s details updated.");
		
		return "/homepage";
	}

	@RequestMapping(value="/contact_us", method = RequestMethod.GET) 
	public String contactUs() {
		return "/contactUs";
	}

	@RequestMapping(value="/faq", method = RequestMethod.GET) 
	public String openFAQ() {
		return "/faq";
	}

	/*
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		return parseErrors(ex.getBindingResult());
	}*/
}