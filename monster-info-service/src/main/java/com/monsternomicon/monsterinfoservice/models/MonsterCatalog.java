package com.monsternomicon.monsterinfoservice.models;

import java.util.List;

import com.monsternomicon.monsterinfoservice.models.Monster;

public class MonsterCatalog {
	
	private List<Monster> catalog;

	public MonsterCatalog() {
		
	}
	
	public MonsterCatalog(List<Monster> catalog) {
		super();
		this.catalog = catalog;
	}

	public List<Monster> getCatalog() {
		return catalog;
	}

	public void setCatalog(List<Monster> catalog) {
		this.catalog = catalog;
	}
}
