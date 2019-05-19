package com.monsternomicon.monstercatalogservice.models;

public class Monster {
	
	public String name;
	
	public String type;
	
	public String size;
	
	public String hitDice;
	
	public int initiative;
	
	public String speed;
	
	public String armorClass;
	
	public int baseAttack;
	
	public int grapple;
	
	public String attack;
	
	public String completeAttack;
	
	public int space;
	
	public int reach;
	
	public String specialAttacks;
	
	public String specialQualities;
	
	public String saves;
	
	public String abilities;
	
	public String skills;
	
	public String feats;
	
	public String environment;
	
	public String organization;
	
	public int challengeRating;
	
	public String treasure;
	
	public String alignment;
	
	public String advancement;
		
	public Monster() {
			
	}
	public Monster(String name, String type, String hd) {
			super();
			this.name = name;
			this.type = type;
			this.hitDice = hd;
	}
	public Monster(Monster monster) {
			this.name = monster.getName();
			this.type = monster.getType();
			this.hitDice = monster.getHitDice();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHitDice() {
		return hitDice;
	}
	public void setHd(String hd) {
		this.hitDice = hd;
	}
}

