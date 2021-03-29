package com.shuvo.ms.searchflightservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SearchFlightServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchFlightServiceApplication.class, args);
	}

}
