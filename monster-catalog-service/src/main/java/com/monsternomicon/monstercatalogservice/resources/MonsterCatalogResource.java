package com.monsternomicon.monstercatalogservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@Autowired
	@LoadBalanced
	private WebClient webClient;
	
	@HystrixCommand(fallbackMethod = "fallBack", commandKey = "getMonsters", groupKey = "Catalog")
	@GetMapping(value = "/monster", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Flux<MonsterItem>> getMonsters(){
		
		try {
			return ResponseEntity.ok(webClient.get()
					.uri("/all")
					.retrieve()
					.onStatus(HttpStatus::is4xxClientError, clientResponse ->
							Mono.error(new Exception())
					)
					.onStatus(HttpStatus::is5xxServerError, clientResponse ->
							Mono.error(new Exception())
					)
					.bodyToFlux(MonsterItem.class));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@GetMapping(value = "/monster/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Monster>> getMonsterInfo(@PathVariable("name") String name){
		
		try {
			return ResponseEntity.ok(webClient.get()
					.uri("/" + name)
					.retrieve()
					.onStatus(HttpStatus::is4xxClientError, clientResponse ->
							Mono.error(new Exception())
					)
					.onStatus(HttpStatus::is5xxServerError, clientResponse ->
							Mono.error(new Exception())
					)
					.bodyToMono(Monster.class));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@PostMapping(value = "/monster", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Monster>> addMonster(@ModelAttribute Monster request){
		
		try {
			return ResponseEntity.ok(webClient.post()
					//.body(Mono.just(monster), Monster.class)
					.syncBody(request)
					.retrieve()
					.onStatus(HttpStatus::is4xxClientError, clientResponse -> 
							Mono.error(new Exception())
					)
					.onStatus(HttpStatus::is5xxServerError, clientResponse ->
							Mono.error(new Exception())
					)
					.bodyToMono(Monster.class));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@PutMapping(value = "/monster/{name}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Monster>> editMonster(@PathVariable("name") String name, @ModelAttribute Monster request){
		
		try {
			return ResponseEntity.ok(webClient.put()
					.uri("/" + name)
					.syncBody(request)
					.retrieve()
					.onStatus(HttpStatus::is4xxClientError, clientResponse ->
							Mono.error(new Exception())
					)
					.onStatus(HttpStatus::is5xxServerError, clientResponse ->
							Mono.error(new Exception())
					)
					.bodyToMono(Monster.class));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@DeleteMapping(value = "/monster")
	public ResponseEntity<Mono<Void>> deleteAllMonster() {
		
		try {
			return ResponseEntity.ok(webClient.delete()
				.uri("/all")
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, clientResponse ->
						Mono.error(new Exception())
				)
				.onStatus(HttpStatus::is5xxServerError, clientResponse ->
						Mono.error(new Exception())
				)
				.bodyToMono(Void.class));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@HystrixCommand
	@DeleteMapping(value = "/monster/{name}")
	public ResponseEntity<Mono<Void>> deleteMonster(@PathVariable("name") String name){
		
		try {
			return ResponseEntity.ok(webClient.delete()
					.uri("/" + name)
					.retrieve()
					.onStatus(HttpStatus::is4xxClientError, clientResponse ->
							Mono.error(new Exception())
					)
					.onStatus(HttpStatus::is5xxServerError, clientResponse ->
							Mono.error(new Exception())
					)
					.bodyToMono(Void.class));
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public ResponseEntity<Flux<MonsterItem>> fallBack(){
		
		Flux<MonsterItem> response = Flux.empty();
		return ResponseEntity.ok(response);
	}
}
