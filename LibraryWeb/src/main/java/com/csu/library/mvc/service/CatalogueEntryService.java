package com.csu.library.mvc.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csu.library.mvc.dto.CatalogueEntry;

@Transactional
@Service("catalogueEntryService")
public interface CatalogueEntryService {

	public void addItem(CatalogueEntry catalogueEntry);
	
	public void removeItem(CatalogueEntry catalogueEntry);
	
	public void updateItem(CatalogueEntry catalogueEntry);

	public CatalogueEntry getItemByTitle(String title);

	public CatalogueEntry getItemByBarcode(Long barcode);

	public ArrayList<CatalogueEntry> getItemsByAuthors(String authors);

	public CatalogueEntry getItemById(Long persistentCatalogueEntryId);

	public Collection<CatalogueEntry> getAllItems();
	
}
