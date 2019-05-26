package com.monsternomicon.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
@EnableHystrix
@EnableHystrixDashboard
public class TurbineDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineDashboardApplication.class, args);
	}

}
