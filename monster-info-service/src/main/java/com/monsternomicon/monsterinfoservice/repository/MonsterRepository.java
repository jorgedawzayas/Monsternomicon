package com.monsternomicon.monsterinfoservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.monsternomicon.monsterinfoservice.models.Monster;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MonsterRepository extends ReactiveCrudRepository <Monster, String>{
	
	public Mono<Monster> findByName (String name);
	
	public Flux<Monster> findByType (String type);
	
	public Flux<Monster> findByHitDice (String hitDice);
		
}
