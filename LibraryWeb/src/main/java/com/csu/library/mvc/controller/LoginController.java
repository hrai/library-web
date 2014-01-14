package com.csu.library.mvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@RequestMapping(value = "/welcome", method=RequestMethod.POST)
	public String homepage(@ModelAttribute(value="userLogin") @Valid UserLogin userLogin, BindingResult bindingResult, Model model, RedirectAttributes redirAttr, HttpSession session) {
		if(bindingResult.hasErrors()) {
			redirAttr.addFlashAttribute("org.springframework.validation.BindingResult.userLogin", bindingResult);
			redirAttr.addFlashAttribute("userLogin", userLogin);
		    
			return "redirect:/";
		}
		else {
			User userDB = userService.login(userLogin);
			if(userDB != null) {
				session.removeAttribute("user");
				session.setAttribute("user", userDB);
				session.setAttribute("search", new Search());
				
				session.setAttribute("isLibrarian", true);
				
				//if(!(userDB instanceof Librarian)) {
					session.setAttribute("isLibrarian", false);
					model.addAttribute("currentLoans", loanService.getCurrentLoansForDisplay(userDB));
				//}
				
				logger.info("User {} just logged in. {}", userDB.getUsername(), new Date());
				return "/homepage";
			}
			else {
				userLogin.setErrorFindingUser("Incorrect username/password.");
				redirAttr.addFlashAttribute("userLogin", userLogin);
				return "redirect:/";
			}
		}
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET) 
	public String redirectToHomepage(@ModelAttribute User user, Model model) {
		model.addAttribute("currentLoans", loanService.getCurrentLoansForDisplay(user));

		return "/homepage";
	}
	
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
