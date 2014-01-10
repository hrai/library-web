package com.csu.library.mvc.dao.implementation;

import org.springframework.stereotype.Repository;

import com.csu.library.mvc.dao.LibrarianDao;
import com.csu.library.mvc.dao.generic.GenericHibernateDao;
import com.csu.library.mvc.dto.Librarian;

@Repository("librarianDao")
public class LibrarianDaoImpl extends GenericHibernateDao<Librarian, Long> implements LibrarianDao {

}
