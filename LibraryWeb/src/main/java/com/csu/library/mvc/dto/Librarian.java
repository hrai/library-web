/*package com.csu.library.mvc.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.springframework.context.annotation.Scope;

@Scope("session")
@Entity
@DiscriminatorValue("L")
public class Librarian extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Collection<CatalogueEntry> ctlgEntryList = new TreeSet<CatalogueEntry>();
	
	@OneToMany(mappedBy="librarian")//cascade=CascadeType.PERSIST)
	@Valid
	public Collection<CatalogueEntry> getCtlgEntryList() {
		return ctlgEntryList;
	}
	
	public void setCtlgEntryList(Collection<CatalogueEntry> ctlgEntryList) {
		this.ctlgEntryList = ctlgEntryList;
	}
	
	public void addCatalogueEntryList(CatalogueEntry ctlgEntryList) {
		this.getCtlgEntryList().add(ctlgEntryList);
		ctlgEntryList.setLibrarian(this);
	}
}
*/