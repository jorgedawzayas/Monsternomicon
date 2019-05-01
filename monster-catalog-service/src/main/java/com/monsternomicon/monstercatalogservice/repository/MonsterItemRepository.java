package com.monsternomicon.monstercatalogservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.monsternomicon.monstercatalogservice.models.MonsterItem;

public interface MonsterItemRepository extends MongoRepository <MonsterItem, String> {

}
