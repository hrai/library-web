package com.csu.library.mvc.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csu.library.mvc.dao.ProfessorDao;
import com.csu.library.mvc.dto.Professor;
import com.csu.library.mvc.service.ProfessorService;

@Service("professorService")
public class ProfessorServiceImpl implements ProfessorService {

	@Inject
	ProfessorDao professorDao;
	
	public void saveProfessor(Professor professor) {
		professor.setNoOfLoans(0);
		professor.setNoOfReservations(0);
		professorDao.save(professor);
	}

}
