package com.monsternomicon.monsteraddservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monsternomicon.monsteraddservice.models.Monster;

@RestController
@RequestMapping("/add")
public class AddMonsterResource {
	
	@RequestMapping("/{name}")
	public Monster getMonster(@PathVariable("name") String name) {
		return new Monster(name, "Limo", 12);
	}

}
