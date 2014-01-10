package com.csu.library.mvc.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csu.library.mvc.dao.StudentDao;
import com.csu.library.mvc.dto.Student;
import com.csu.library.mvc.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Inject
	StudentDao studentDao;
	
	public void saveStudent(Student student) {
		student.setNoOfLoans(0);
		student.setNoOfReservations(0);
		studentDao.save(student);
	}

}
