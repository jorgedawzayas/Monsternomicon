package com.monsternomicon.monsterinfoservice.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.monsternomicon.monsterinfoservice.models.Monster;
import com.monsternomicon.monsterinfoservice.repository.MonsterRepository;


@RestController
@RequestMapping(value = "/monster", produces = MediaType.APPLICATION_JSON_VALUE)
public class MonsterInfoResource {
	
	@Autowired
	MonsterRepository monsterRepository;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@GetMapping("/{name}")
	public ResponseEntity<Monster> getMonsterInfo(@PathVariable("name") String name) {
		
		Monster monster = monsterRepository.findByName(name);
		return ResponseEntity.ok(monster);
	}
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Monster> addMonster(@ModelAttribute Monster monsterRequest){
		
		Monster monster = new Monster(monsterRequest);
		monsterRepository.save(monster);
		
		/*webClientBuilder.build()
			.post()
			.uri("http://192.168.1.37:8084/api/catalog/" + monster.getName())
			.exchange();*/
		
		return ResponseEntity.ok(monster);
	}
	
	@PutMapping(value = "{name}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Monster> editMonster(@PathVariable("name") String name, @ModelAttribute Monster monsterRequest){
		
		Monster monster = new Monster(monsterRequest);
		monsterRepository.save(monster);
		
		return ResponseEntity.ok(monster);
	}
	
	@DeleteMapping("{name}")
	public ResponseEntity<?> deleteMonster(@PathVariable("name") String name){
		
		monsterRepository.deleteById(name);
		
		return ResponseEntity.noContent().build();
	}
	
}
