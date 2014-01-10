package com.csu.library.mvc.dao.implementation;

import org.springframework.stereotype.Repository;

import com.csu.library.mvc.dao.FineDao;
import com.csu.library.mvc.dao.generic.GenericHibernateDao;
import com.csu.library.mvc.dto.Fine;

@Repository("fineDao")
public class FineDaoImpl extends GenericHibernateDao<Fine, Long> implements FineDao {


}
