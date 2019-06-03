package com.monsternomicon.monstercatalogservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.monsternomicon.monstercatalogservice.models.Monster;
import com.monsternomicon.monstercatalogservice.models.MonsterItem;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
public class MonsterCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient webClient;
	
	@Autowired
	private Environment env;
	
	@HystrixCommand
	@GetMapping(value = "/monster", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Flux<MonsterItem>> getMonsters(){
		
		try {
			Flux<MonsterItem> monsters = webClient.get()
					.uri("/all")
					.retrieve()
					.bodyToFlux(MonsterItem.class);
			
			Flux<MonsterItem> defaultFlux = HystrixCommands.from(monsters)
					.commandName("Get Monsters")
					.fallback(Flux.empty())
					.toFlux();
			
			return ResponseEntity.ok(defaultFlux);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@GetMapping(value = "/monster/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Monster>> getMonsterInfo(@PathVariable("name") String name){
		
		try {
			Mono<Monster> monster = webClient.get()
					.uri("/" + name)
					.retrieve()
					.bodyToMono(Monster.class);
			
			Mono<Monster> defaultMono = HystrixCommands.from(monster)
					.commandName("Get Monster")
					.fallback(Mono.empty())
					.toMono();
			
			return ResponseEntity.ok(defaultMono);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@PostMapping(value = "/monster", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Monster>> addMonster(@ModelAttribute Monster request){
		
		try {
			Mono<Monster> monsterPost = webClient.post()
					//.body(Mono.just(monster), Monster.class)
					.syncBody(request)
					.retrieve()
					.bodyToMono(Monster.class);
			
			Mono<Monster> defaultMono = HystrixCommands.from(monsterPost)
					.commandName("Post Monster")
					.fallback(Mono.empty())
					.toMono();
			
			return ResponseEntity.ok(defaultMono);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@PutMapping(value = "/monster/{name}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Monster>> editMonster(@PathVariable("name") String name, @ModelAttribute Monster request){
		
		try {
			Mono<Monster> monsterPut = webClient.put()
					.uri("/" + name)
					.syncBody(request)
					.retrieve()
					.bodyToMono(Monster.class);
			
			Mono<Monster> defaultMono = HystrixCommands.from(monsterPut)
					.commandName("Put Monster")
					.fallback(Mono.empty())
					.toMono();
			
			return ResponseEntity.ok(defaultMono);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@DeleteMapping(value = "/monster")
	public ResponseEntity<Mono<Void>> deleteAllMonster() {
		
		try {
			Mono<Void> deleteMonsters = webClient.delete()
				.uri("/all")
				.retrieve()
				.bodyToMono(Void.class);
			
			Mono<Void> defaultMono = HystrixCommands.from(deleteMonsters)
					.commandName("Delete Monsters")
					.fallback(Mono.empty())
					.toMono();
			
			return ResponseEntity.ok(defaultMono);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@DeleteMapping(value = "/monster/{name}")
	public ResponseEntity<Mono<Void>> deleteMonster(@PathVariable("name") String name){
		
		try {
			Mono<Void> deleteMonster = webClient.delete()
					.uri("/" + name)
					.retrieve()
					.bodyToMono(Void.class);
			
			Mono<Void> defaultMono = HystrixCommands.from(deleteMonster)
					.commandName("Delete Monster")
					.fallback(Mono.empty())
					.toMono();
			
			return ResponseEntity.ok(defaultMono);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@GetMapping(value = "/status")
	public String status() {
		
		return "Working on port " + env.getProperty("local.server.port");
	}
	
	
}
