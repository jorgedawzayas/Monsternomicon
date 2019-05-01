package com.monsternomicon.monsterinfoservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monsternomicon.monsterinfoservice.models.Monster;
import com.monsternomicon.monsterinfoservice.models.MonsterCatalog;
import com.monsternomicon.monsterinfoservice.repository.MonsterRepository;

@RestController
@RequestMapping("/monster")
public class MonsterInfoResource {
	
	@Autowired
	MonsterRepository monsterRepository;
	
	@RequestMapping("/all")
	public List<Monster> getAllMonsters() {
		return monsterRepository.findAll();
		
	}
	
	@RequestMapping("/{name}")
	public Monster getMonsterInfo(@PathVariable("name") String name) {
		
		return monsterRepository.findByName(name);
		//return new Monster(name, "Humanoid", 3);	
	}

}
