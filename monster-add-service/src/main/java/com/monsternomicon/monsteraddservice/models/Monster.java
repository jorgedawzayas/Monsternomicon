package com.monsternomicon.monsteraddservice.models;

public class Monster {
	
	public String name;
	public String race;
	public int dg;
	
	public Monster(String name, String race, int dg) {
		super();
		this.name = name;
		this.race = race;
		this.dg = dg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public int getDg() {
		return dg;
	}
	public void setDg(int dg) {
		this.dg = dg;
	}
}
