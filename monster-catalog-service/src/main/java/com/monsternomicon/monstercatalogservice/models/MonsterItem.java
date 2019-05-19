package com.monsternomicon.monstercatalogservice.models;

public class MonsterItem {
	
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
