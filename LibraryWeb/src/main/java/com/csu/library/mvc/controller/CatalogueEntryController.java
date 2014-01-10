package com.csu.library.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.csu.library.mvc.dto.CatalogueEntry;
import com.csu.library.mvc.dto.User;
import com.csu.library.mvc.service.CatalogueEntryService;
import com.csu.library.mvc.service.LoanService;
import com.csu.library.mvc.service.UserService;

@SessionAttributes({"oldCatalogueEntry", "user", "search"})
@Controller
public class CatalogueEntryController {
	
	@Inject
	private CatalogueEntryService catalogueEntryService;
	@Inject
	private LoanService loanService;
	@Inject
	private UserService userService;

	@RequestMapping(value = "/catalogue_entry_form", method = RequestMethod.GET)
	public String openCatalogueEntryForm(@ModelAttribute User librarian) {
		return "/catalogueEntryForm";
	}
	
	@RequestMapping(value = "/add_item", method = RequestMethod.POST)
	public String addCatalogueEntry(@ModelAttribute @Valid CatalogueEntry catalogueEntry, BindingResult bindingResult, @ModelAttribute User user) {
		catalogueEntry.setLibrarian(user);

		if(bindingResult.hasErrors()) {
			List<FieldError> errs = bindingResult.getFieldErrors();
			for(FieldError e: errs) {
				if(e.getField().equals("available"))
					continue;
				if(e.getField().equals("loaned"))
					continue;
				if(e.getField().equals("reserved"))
					continue;
				if(e.getField().equals("librarian"))
					continue;
				
				return "/catalogueEntryForm";
			}

			catalogueEntryService.addItem(catalogueEntry);

			return "/homepage";
		}

		return "/catalogueEntryForm";
	}

	@RequestMapping(value="/open/{barcode}", method=RequestMethod.GET)
	public String openCatalogueEntryDetails(@PathVariable Long barcode, Model model) {
		CatalogueEntry item = catalogueEntryService.getItemByBarcode(barcode);
		model.addAttribute("catalogueEntry", item);
		
		return "/displayItem";
	}
	
	@RequestMapping(value="/remove_item/{barcode}", method=RequestMethod.GET) 
	public String removeItem(@PathVariable Long barcode) {
		catalogueEntryService.removeItem(catalogueEntryService.getItemByBarcode(barcode));
		
		return "/homepage";
	}
	
	@RequestMapping(value="/edit_item/{barcode}", method=RequestMethod.GET)
	public String editItem(@PathVariable Long barcode, Model model) {
		model.addAttribute("oldCatalogueEntry", catalogueEntryService.getItemByBarcode(barcode));
		
		return "/catalogueEntryForm";
	}
	
	@RequestMapping(value="/update_item", method=RequestMethod.POST)
	public String updateItem(@ModelAttribute("oldCatalogueEntry") @Valid CatalogueEntry oldCatalogueEntry, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) 
			return "/catalogueEntryForm";
		else {
			catalogueEntryService.updateItem(oldCatalogueEntry);
			
			return "/homepage";
		}
	}
	
	@ModelAttribute
	public CatalogueEntry catalogueEntryModelAttribute() {
		return new CatalogueEntry();
	}
	
	@ModelAttribute
	public Map<Integer, Integer> yearPublishedModelAttribute() {
		Map<Integer, Integer> years = new HashMap<Integer, Integer>();
		for(int i = 2013; i >= 1900; i--) {
			years.put(i, i);
		}
		
		return years;
	}
	
}
