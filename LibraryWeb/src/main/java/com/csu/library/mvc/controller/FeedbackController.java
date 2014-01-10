package com.csu.library.mvc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.csu.library.mvc.dao.UserDao;
import com.csu.library.mvc.dto.Feedback;
import com.csu.library.mvc.dto.User;
import com.csu.library.mvc.service.FeedbackService;

@SessionAttributes("user")
@Controller
public class FeedbackController {
	
	@Inject
	UserDao userDao;
	@Inject
	FeedbackService feedbackService;
	
	@RequestMapping(value="/feedback_form", method=RequestMethod.GET)
	public String openFeedbackForm(Model model) {
		model.addAttribute("feedback", new Feedback());
		
		return "/feedbackForm";
	}
	
	@RequestMapping(value="/save_feedback", method=RequestMethod.POST)
	public String saveFeedbackForm(@ModelAttribute User user, @ModelAttribute Feedback feedback) {
		feedbackService.saveFeedback(feedback, userDao.find(user.getUserId(), true));
		
		return "/homepage";
	}
	
	@RequestMapping(value="/display_feedback_list", method=RequestMethod.GET)
	public String getFeedbackListForDisplay(Model model) {
		model.addAttribute("feedbackList", feedbackService.getFeedbackDisplayList());
		
		return "/displayFeedbackList";
	}
}
