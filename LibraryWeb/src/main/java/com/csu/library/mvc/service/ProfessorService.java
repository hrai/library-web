package com.csu.library.mvc.service;

import org.springframework.transaction.annotation.Transactional;

import com.csu.library.mvc.dto.Professor;

@Transactional
public interface ProfessorService {
	
	public void saveProfessor(Professor professor);
	
}
