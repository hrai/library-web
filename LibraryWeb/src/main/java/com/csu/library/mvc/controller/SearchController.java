package com.csu.library.mvc.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.csu.library.mvc.beans.Search;
import com.csu.library.mvc.dto.CatalogueEntry;
import com.csu.library.mvc.service.CatalogueEntryService;

@Controller
public class SearchController {
	
	@Inject
	private CatalogueEntryService catalogueEntryService;
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String openSearchPage(Model model) {
		model.addAttribute("search", new Search());
		
		return "/search";
	}
	
	@RequestMapping(value="/search_result", method=RequestMethod.GET)
	public String displaySearch(@RequestParam String searchQuery, @RequestParam Integer searchOption, Model model) {
		Collection<CatalogueEntry> catalogueEntries = new ArrayList<CatalogueEntry>();
		
		if(searchQuery.length()==0)
			if(searchOption!=0)
				return "/noSearchResult";
			else
				catalogueEntries = catalogueEntryService.getAllItems();
		
		else if(searchOption == 1) {
			catalogueEntries = catalogueEntryService.getItemsByAuthors(searchQuery);
		}
		else if(searchOption == 2) {
			catalogueEntries.add(catalogueEntryService.getItemByBarcode(Long.parseLong(searchQuery)));
		}
		else if(searchOption == 3) {
			catalogueEntries.add(catalogueEntryService.getItemByTitle(searchQuery));
		}
		
		if(catalogueEntries == null || catalogueEntries.size() == 0)
			return "/noSearchResult";
		
		model.addAttribute("catalogueEntries", catalogueEntries);
		return "/searchresult";
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

	@ModelAttribute(value="search")
	public Search searchObjectModelAttribute() {
		return new Search();
	}

}
