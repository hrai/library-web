package com.csu.library.mvc.service;

import org.springframework.transaction.annotation.Transactional;

import com.csu.library.mvc.dto.Student;

@Transactional
public interface StudentService {
	
	public void saveStudent(Student student);

}
