package com.monsternomicon.monstercatalogservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MonsterItem {
	
	@Id
	private String name;
	
	public MonsterItem() {
		
	}
	public MonsterItem(String name) {
		this.name = name;
	}
	public MonsterItem(MonsterItem monsterItem) {
		this.name = monsterItem.getName();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
