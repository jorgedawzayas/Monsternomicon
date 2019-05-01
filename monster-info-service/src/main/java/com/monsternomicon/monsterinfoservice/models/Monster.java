package com.monsternomicon.monsterinfoservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Monster {
	
	@Id
	public String name;
	public String race;
	public int dg;
	
	public Monster() {
		
	}
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
