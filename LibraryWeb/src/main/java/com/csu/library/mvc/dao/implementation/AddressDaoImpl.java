package com.csu.library.mvc.dao.implementation;

import org.springframework.stereotype.Repository;
import com.csu.library.mvc.dao.AddressDao;
import com.csu.library.mvc.dao.generic.GenericHibernateDao;
import com.csu.library.mvc.dto.Address;

@Repository("addressDao")
public class AddressDaoImpl extends GenericHibernateDao<Address, Integer> implements AddressDao {

}
