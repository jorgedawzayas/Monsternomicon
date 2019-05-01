package com.monsternomicon.monsterinfoservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.monsternomicon.monsterinfoservice.models.Monster;

public interface MonsterRepository extends MongoRepository <Monster, String>{
	
	public Monster findByName (String name);
		
}
