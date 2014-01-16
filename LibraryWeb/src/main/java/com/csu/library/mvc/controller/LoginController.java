package com.csu.library.mvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.csu.library.mvc.beans.Search;
import com.csu.library.mvc.beans.UserLogin;
import com.csu.library.mvc.dto.User;
import com.csu.library.mvc.service.LoanService;
import com.csu.library.mvc.service.UserService;

@SessionAttributes({"user", "currentLoans", "searchOptions", "search"})
@Controller
public class LoginController {

	@Inject
	private UserService userService;
	@Inject
	private LoanService loanService;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String redirectLogin() {
		logger.info("Redirecting to login page.");

		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "/login";
	}

	@RequestMapping(value = "/welcome", method=RequestMethod.GET)
	public String homepage(Model model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String sUsername = auth.getName();

		System.out.println(sUsername);
		
		User user = userService.getUser(sUsername);
		model.addAttribute("user", user);
		model.addAttribute("search", new Search());
		model.addAttribute("currentLoans", loanService.getCurrentLoansForDisplay(user));
		model.addAttribute("currentLoans", loanService.getCurrentLoansForDisplay(user));

		logger.info("User {} just logged in. {}", user.getUsername(), new Date());
		return "/homepage";
	}
/*
	@RequestMapping(value = "/welcome", method = RequestMethod.GET) 
	public String redirectToHomepage(@ModelAttribute User user, Model model) {
		
		return "/homepage";
	}
*/
	@ModelAttribute(value="userLogin")
	public UserLogin userLoginModelAttribute() {
		return new UserLogin();
	}

	@ModelAttribute(value="searchOptions")
	public Map<Integer, String> searchOptionsModelAttribute() {
		Map<Integer, String> searchOptions = new HashMap<Integer, String>();
		searchOptions.put(0, "Search Option...");
		searchOptions.put(1, "Author");
		searchOptions.put(2, "Barcode");
		searchOptions.put(3, "Title");

		return searchOptions;
	}

}
