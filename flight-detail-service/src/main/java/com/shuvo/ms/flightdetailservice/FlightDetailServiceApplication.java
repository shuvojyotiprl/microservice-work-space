package com.shuvo.ms.flightdetailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FlightDetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightDetailServiceApplication.class, args);
	}

}
