package com.csu.library.mvc.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csu.library.mvc.dao.LibrarianDao;
import com.csu.library.mvc.dto.Librarian;
import com.csu.library.mvc.service.LibrarianService;

@Service("librarianService")
public class LibrarianServiceImpl implements LibrarianService {
	
	@Inject
	private LibrarianDao librarianDao;

	public void saveLibrarian(Librarian librarian) {
		librarianDao.save(librarian);
		
	}

}
