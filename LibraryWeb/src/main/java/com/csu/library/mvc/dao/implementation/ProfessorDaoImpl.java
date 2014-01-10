package com.csu.library.mvc.dao.implementation;

import org.springframework.stereotype.Repository;

import com.csu.library.mvc.dao.ProfessorDao;
import com.csu.library.mvc.dao.generic.GenericHibernateDao;
import com.csu.library.mvc.dto.Professor;

@Repository("professorDao")
public class ProfessorDaoImpl extends GenericHibernateDao<Professor, Long> implements
		ProfessorDao {

}
