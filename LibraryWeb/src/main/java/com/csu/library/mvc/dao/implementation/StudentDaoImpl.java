package com.csu.library.mvc.dao.implementation;

import org.springframework.stereotype.Repository;

import com.csu.library.mvc.dao.StudentDao;
import com.csu.library.mvc.dao.generic.GenericHibernateDao;
import com.csu.library.mvc.dto.Student;

@Repository("studentDao")
public class StudentDaoImpl extends GenericHibernateDao<Student, Long> implements
		StudentDao {


}
