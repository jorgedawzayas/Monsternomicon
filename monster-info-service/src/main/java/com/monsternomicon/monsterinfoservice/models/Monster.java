package com.monsternomicon.monsterinfoservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Monster {
	
	@Id
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
	public Monster(String name, String type, String hitDice) {
		super();
		this.name = name;
		this.type = type;
		this.hitDice = hitDice;
	}
	public Monster(Monster monster) {
		this.name = monster.getName();
		this.type = monster.getType();
		this.size = monster.getSize();
		this.hitDice = monster.getHitDice();
		this.initiative = monster.getInitiative();
		this.speed = monster.getSpeed();
		this.armorClass = monster.getArmorClass();
		this.baseAttack = monster.getBaseAttack();
		this.grapple = monster.getGrapple();
		this.attack = monster.getAttack();
		this.completeAttack = monster.getCompleteAttack();
		this.space = monster.getSpace();
		this.reach = monster.getReach();
		this.specialAttacks = monster.getSpecialAttacks();
		this.specialQualities = monster.getSpecialQualities();
		this.saves = monster.getSaves();
		this.abilities = monster.getAbilities();
		this.skills = monster.getSkills();
		this.feats = monster.getFeats();
		this.environment = monster.getEnvironment();
		this.organization = monster.getOrganization();
		this.challengeRating = monster.getChallengeRating();
		this.treasure = monster.getTreasure();
		this.alignment = monster.getAlignment();
		this.advancement = monster.getAdvancement();
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getInitiative() {
		return initiative;
	}
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getArmorClass() {
		return armorClass;
	}
	public void setArmorClass(String armorClass) {
		this.armorClass = armorClass;
	}
	public int getBaseAttack() {
		return baseAttack;
	}
	public void setBaseAttack(int baseAttack) {
		this.baseAttack = baseAttack;
	}
	public int getGrapple() {
		return grapple;
	}
	public void setGrapple(int grapple) {
		this.grapple = grapple;
	}
	public String getAttack() {
		return attack;
	}
	public void setAttack(String attack) {
		this.attack = attack;
	}
	public String getCompleteAttack() {
		return completeAttack;
	}
	public void setCompleteAttack(String completeAttack) {
		this.completeAttack = completeAttack;
	}
	public int getSpace() {
		return space;
	}
	public void setSpace(int space) {
		this.space = space;
	}
	public int getReach() {
		return reach;
	}
	public void setReach(int reach) {
		this.reach = reach;
	}
	public String getSpecialAttacks() {
		return specialAttacks;
	}
	public void setSpecialAttacks(String specialAttacks) {
		this.specialAttacks = specialAttacks;
	}
	public String getSpecialQualities() {
		return specialQualities;
	}
	public void setSpecialQualities(String specialQualities) {
		this.specialQualities = specialQualities;
	}
	public String getSaves() {
		return saves;
	}
	public void setSaves(String saves) {
		this.saves = saves;
	}
	public String getAbilities() {
		return abilities;
	}
	public void setAbilities(String abilities) {
		this.abilities = abilities;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getFeats() {
		return feats;
	}
	public void setFeats(String feats) {
		this.feats = feats;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public int getChallengeRating() {
		return challengeRating;
	}
	public void setChallengeRating(int challengeRating) {
		this.challengeRating = challengeRating;
	}
	public String getTreasure() {
		return treasure;
	}
	public void setTreasure(String treasure) {
		this.treasure = treasure;
	}
	public String getAlignment() {
		return alignment;
	}
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	public String getAdvancement() {
		return advancement;
	}
	public void setAdvancement(String advancement) {
		this.advancement = advancement;
	}
	public void setHitDice(String hitDice) {
		this.hitDice = hitDice;
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
	
}
