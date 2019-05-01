package com.monsternomicon.monstercatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.monsternomicon.monstercatalogservice.models.Monster;
import com.monsternomicon.monstercatalogservice.models.MonsterCatalog;
import com.monsternomicon.monstercatalogservice.models.MonsterItem;
import com.monsternomicon.monstercatalogservice.repository.MonsterItemRepository;
import com.netflix.discovery.DiscoveryClient;

@RestController
@RequestMapping("/catalog")
public class MonsterCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	MonsterItemRepository monsterItemRepository;
	
	@RequestMapping("")
	public List<MonsterItem> getMonsters(){
		
		return monsterItemRepository.findAll();
		/*MonsterCatalog monsters = webClientBuilder.build()
				.get()
				.uri("http://localhost:8082/monster/all")
				.retrieve()
				.bodyToMono(MonsterCatalog.class)
				.block();*/
		
		/*List<Monster> monsters = Arrays.asList(
				new Monster("Liche", "Undead", 18),
				new Monster("Beholder", "Aberration", 15),
				new Monster("Iron Golem", "Construct", 12),
				new Monster("Mindflayer", "Aberration", 8)
		);*/
		
		/*System.out.println("---------------------->" + monsters);
		return monsters.stream().map(monster -> {
			//Monster monsterItem = restTemplate.getForObject("http://localhost:8082/monster/" + monster.getName(), Monster.class);
			Monster monsterItem = webClientBuilder.build()
				.get()
				.uri("http://monster-info-service/monster/" + monster.getName())
				.retrieve()
				.bodyToMono(Monster.class)
				.block();
			return new MonsterItem(monsterItem.getName());
		})
		.collect(Collectors.toList());*/
		
		/*return Collections.singletonList(
				new MonsterItem("Kobold")
		);*/
	}
}
