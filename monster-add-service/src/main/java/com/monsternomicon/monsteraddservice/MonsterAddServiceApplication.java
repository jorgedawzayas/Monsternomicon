package com.monsternomicon.monsteraddservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MonsterAddServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonsterAddServiceApplication.class, args);
	}

}
