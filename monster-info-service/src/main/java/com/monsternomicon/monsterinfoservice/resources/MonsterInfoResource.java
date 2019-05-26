package com.monsternomicon.monsterinfoservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.monsternomicon.monsterinfoservice.models.Monster;
import com.monsternomicon.monsterinfoservice.models.MonsterItem;
import com.monsternomicon.monsterinfoservice.repository.MonsterRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/monster", produces = MediaType.APPLICATION_JSON_VALUE)
public class MonsterInfoResource {
	
	@Autowired
	MonsterRepository monsterRepository;
	
	@LoadBalanced
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@HystrixCommand
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<MonsterItem> getAllMonsters(){
		
		try {
			return monsterRepository.findAll().map(MonsterItem::new);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Monster> getMonsterInfo(@PathVariable("name") String name) {
		
		try {
			return monsterRepository.findByName(name)
					.switchIfEmpty(Mono.error(new Exception("No hay ningún Monstruo con el nombre: " + name)));
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@PostMapping(/*consumes = MediaType.MULTIPART_FORM_DATA_VALUE,*/ produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Monster> addMonster(@ModelAttribute Monster monsterRequest){
		
		try {
			return monsterRepository.save(monsterRequest);
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@PutMapping(value = "{name}", /*consumes = MediaType.MULTIPART_FORM_DATA_VALUE*/ produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Monster> editMonster(@PathVariable("name") String name, @ModelAttribute Monster monsterRequest){
		
		try {
			return monsterRepository.findById(name).doOnSuccess(findMonster -> {
				findMonster.setType(monsterRequest.getType());
				findMonster.setHitDice(monsterRequest.getHitDice());
				monsterRepository.save(findMonster).subscribe();
			});
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@DeleteMapping(value = "{name}")
	public Mono<Void> deleteMonster(@PathVariable("name") String name){
		
		try {
			return monsterRepository.deleteById(name);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
		
	}
	
	@HystrixCommand
	@DeleteMapping(value = "/all")
	public Mono<Void> deleteAllMonsters() {
		
		try {
			return monsterRepository.deleteAll();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
}
