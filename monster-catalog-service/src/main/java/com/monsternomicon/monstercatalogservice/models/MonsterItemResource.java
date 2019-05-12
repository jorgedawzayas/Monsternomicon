package com.monsternomicon.monstercatalogservice.models;

import org.springframework.hateoas.ResourceSupport;

public class MonsterItemResource extends ResourceSupport {
	
	
	private String name;
	
	public MonsterItemResource(MonsterItem monsterItem) {
		this.name = monsterItem.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
