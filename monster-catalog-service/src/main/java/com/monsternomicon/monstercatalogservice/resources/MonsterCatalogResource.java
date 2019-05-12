package com.monsternomicon.monstercatalogservice.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.monsternomicon.monstercatalogservice.models.MonsterItem;
import com.monsternomicon.monstercatalogservice.models.MonsterItemResource;
import com.monsternomicon.monstercatalogservice.repository.MonsterItemRepository;


@RestController
@RequestMapping(value = "/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
public class MonsterCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	MonsterItemRepository monsterItemRepository;
	
	@GetMapping
	public ResponseEntity<Resources<MonsterItemResource>> getMonsters(){
		
		List<MonsterItemResource> collection = monsterItemRepository.findAll().stream().map(MonsterItemResource::new).collect(Collectors.toList());
		
		for(MonsterItemResource monster : collection) {
			
			String name = monster.getName();
			String uriString = ServletUriComponentsBuilder.fromHttpUrl("http://192.168.1.37:8084/api/monster/" + name).build().toUriString();
			monster.add(new Link(uriString, "info"));
		}
		
		Resources<MonsterItemResource> resources = new Resources<MonsterItemResource>(collection);

		return ResponseEntity.ok(resources);

	}
	
	@PostMapping("{name}")
	public ResponseEntity<MonsterItem> addMonster(@PathVariable("name") String name){
		
		MonsterItem monsterItem = new MonsterItem(name);
		monsterItemRepository.save(monsterItem);
		
		return ResponseEntity.ok(monsterItem);
	}
}
