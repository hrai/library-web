package com.csu.library.mvc.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csu.library.mvc.dao.CatalogueEntryDao;
import com.csu.library.mvc.dto.CatalogueEntry;
import com.csu.library.mvc.service.CatalogueEntryService;

@Service("catalogueEntryService")
public class CatalogueEntryServiceImpl implements CatalogueEntryService {
	
	@Inject
	private CatalogueEntryDao catalogueEntryDao;
	
	public ArrayList<CatalogueEntry> getItemsByAuthors(String authors) {
		return (ArrayList<CatalogueEntry>) catalogueEntryDao.getCatalogueEntriesByAuthors(authors);
	}
	
	public CatalogueEntry getItemByBarcode(Long barcode) {
		return catalogueEntryDao.getCatalogueEntryByBarcode(barcode);
	}
	
	public CatalogueEntry getItemByTitle(String title) {
		return catalogueEntryDao.getCatalogueEntryByTitle(title);
	}

	public CatalogueEntry getItemById(Long persistentCatalogueEntryId) {
		return catalogueEntryDao.getCatalogueEntryById(persistentCatalogueEntryId);
	}

	public Collection<CatalogueEntry> getAllItems() {
		return catalogueEntryDao.findAll();
	}

	public void addItem(CatalogueEntry catalogueEntry) {
		catalogueEntry.setAvailable(true);
		catalogueEntry.setLoaned(false);
		catalogueEntry.setReserved(false);
		catalogueEntryDao.save(catalogueEntry);
	}

	public void removeItem(CatalogueEntry catalogueEntry) {
		catalogueEntryDao.delete(catalogueEntry);
	}

	public void updateItem(CatalogueEntry catalogueEntry) {
		catalogueEntryDao.update(catalogueEntry);
	}

}
