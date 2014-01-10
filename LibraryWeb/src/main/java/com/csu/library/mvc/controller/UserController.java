package com.csu.library.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.csu.library.mvc.dto.Librarian;
import com.csu.library.mvc.dto.Professor;
import com.csu.library.mvc.dto.Student;
import com.csu.library.mvc.dto.User;
import com.csu.library.mvc.helpers.Helper;
import com.csu.library.mvc.service.LibrarianService;
import com.csu.library.mvc.service.ProfessorService;
import com.csu.library.mvc.service.StudentService;
import com.csu.library.mvc.service.UserService;

@SessionAttributes({"searchOptions", "search", "user"})
@Controller
public class UserController {

	@Inject
	private UserService userService;
	@Inject
	private LibrarianService librarianService;
	@Inject
	private ProfessorService professorService;
	@Inject
	private StudentService studentService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET) 
	public String registrationPage(Model model) {
		model.addAttribute("user", new User());
		
		return "/registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveNewUser(@Valid User user, BindingResult bindingResult, @RequestParam Integer selectedType) {

		if(bindingResult.hasErrors()) {
			return "/registration";
		}

		if(selectedType==1) {
			Librarian librarian = new Librarian();
			Helper.copyBeanProperties(user, librarian);
			librarianService.saveLibrarian(librarian);
		}
		else if(selectedType==2) {
			Professor professor = new Professor();
			Helper.copyBeanProperties(user, professor);
			professorService.saveProfessor(professor);
		}
		else if(selectedType==3) {
			Student student = new Student();
			Helper.copyBeanProperties(user, student);
			studentService.saveStudent(student);
		}
		return "/homepage";
	}

	@RequestMapping(value="/edit_user_details", method = RequestMethod.GET)
	public String editUserDetails(/*@ModelAttribute User librarian,*/ @ModelAttribute User user, Model model) {
		//User editableUser = (librarian!=null)?librarian:user;
		//model.addAttribute("editableUser", editableUser);
		//model.addAttribute("editableUser", user);
		
		return "/editUserInfo";
	}

	@RequestMapping(value="/update_user_details", method = RequestMethod.POST) 
	public String updateUserDetails(@Valid @ModelAttribute User editableUser, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "/editUserInfo";
		
		userService.updateUser(editableUser);

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

	@ModelAttribute(value = "securityQuestions")
	public Map<Integer, String> securityQuestionsModelAttribute() {
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

	@ModelAttribute(value = "userTypes")
	public Map<Integer, String> userTypeModelAttribute() {
		Map<Integer, String> userTypes = new HashMap<Integer, String>();
		userTypes.put(0, "Select...");
		userTypes.put(1, "Librarian");
		userTypes.put(2, "Professor");
		userTypes.put(3, "Student");

		return userTypes;
	}

	/*
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		return parseErrors(ex.getBindingResult());
	}*/
}