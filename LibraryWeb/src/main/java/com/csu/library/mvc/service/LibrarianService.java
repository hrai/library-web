package com.csu.library.mvc.service;

import org.springframework.transaction.annotation.Transactional;

import com.csu.library.mvc.dto.Librarian;

@Transactional
public interface LibrarianService {
	
	public void saveLibrarian(Librarian librarian);
	
}
