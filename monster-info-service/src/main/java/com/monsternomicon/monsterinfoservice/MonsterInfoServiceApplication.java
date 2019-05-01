package com.monsternomicon.monsterinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MonsterInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonsterInfoServiceApplication.class, args);
	}

}
