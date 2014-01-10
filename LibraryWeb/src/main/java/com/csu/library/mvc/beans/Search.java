package com.csu.library.mvc.beans;

import org.springframework.stereotype.Repository;

@Repository
public class Search {
	
	private String searchQuery;
	private Integer searchOption;

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public Integer getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(Integer searchOption) {
		this.searchOption = searchOption;
	}
	
}
