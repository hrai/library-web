package com.csu.library.mvc.dao.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.csu.library.mvc.dao.CatalogueEntryDao;
import com.csu.library.mvc.dao.generic.GenericHibernateDao;
import com.csu.library.mvc.dto.CatalogueEntry;
import com.csu.library.mvc.dto.Loan;

@Repository("catalogueEntryDao")
public class CatalogueEntryDaoImpl extends GenericHibernateDao<CatalogueEntry, Long> implements CatalogueEntryDao {

	@SuppressWarnings("unchecked")
	public List<CatalogueEntry> getCatalogueEntriesByAuthors(String authors) {
		Criterion criterion = Restrictions.eq("authors", authors);
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass()).add(criterion).addOrder(Order.asc("authors"));
		
		List<CatalogueEntry> catalogueEntries = criteria.list();
		
		return catalogueEntries.size()!=0?catalogueEntries:null;
	}

	public CatalogueEntry getCatalogueEntryByBarcode(Long barcode) {
		Criterion criterion = Restrictions.eq("barcode", barcode);
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass()).add(criterion).addOrder(Order.asc("barcode"));
		
		CatalogueEntry catalogueEntry = (CatalogueEntry) criteria.uniqueResult();
		
		return catalogueEntry==null?null:catalogueEntry;
	}
	
	public CatalogueEntry getCatalogueEntryByTitle(String title) {
		Criterion criterion = Restrictions.eq("title", title);
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass()).add(criterion);

		CatalogueEntry catalogueEntry = (CatalogueEntry) criteria.uniqueResult();
		
		return catalogueEntry==null?null:catalogueEntry;
	}
	
	public CatalogueEntry getCatalogueEntryById(Long id) {
		Criterion criterion = Restrictions.eq("catalogueEntryId", id);
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass()).add(criterion);

		CatalogueEntry catalogueEntry = (CatalogueEntry) criteria.uniqueResult();
		
		return catalogueEntry==null?null:catalogueEntry;
	}

	public CatalogueEntry getCatalogueEntryByLoan(Loan loan) {
		String hqlQuery = "select catalogueEntry from CatalogueEntry catalogueEntry " +
				"join fetch catalogueEntry.loanList loanList " +
				"where :loan in elements(loanList)";
		
		Query query = getSessionFactory().getCurrentSession().createQuery(hqlQuery);
		query.setParameter("loan", loan);

		CatalogueEntry catalogueEntry = (CatalogueEntry) query.uniqueResult();
		
		return catalogueEntry==null?null:catalogueEntry;
	}

}
