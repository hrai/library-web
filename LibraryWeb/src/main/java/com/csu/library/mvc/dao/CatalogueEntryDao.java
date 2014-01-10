package com.csu.library.mvc.dao;

import java.util.List;

import com.csu.library.mvc.dao.generic.GenericDao;
import com.csu.library.mvc.dto.CatalogueEntry;
import com.csu.library.mvc.dto.Loan;

public interface CatalogueEntryDao extends GenericDao<CatalogueEntry, Long>{
	
	public CatalogueEntry getCatalogueEntryByTitle(String title);

	public List<CatalogueEntry> getCatalogueEntriesByAuthors(String authors);

	public CatalogueEntry getCatalogueEntryByBarcode(Long barcode);

	public CatalogueEntry getCatalogueEntryById(Long id);

	public CatalogueEntry getCatalogueEntryByLoan(Loan loan);

}
