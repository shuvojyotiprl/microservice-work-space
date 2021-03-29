package com.shuvo.ms.flightbooking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.shuvo.ms.flightbooking.models.FlightBooking;

@SpringBootApplication
@EnableEurekaClient
public class FlightBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingApplication.class, args);
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public List<FlightBooking> getAvlFlightBookingList(){
		return new ArrayList<FlightBooking>();
	}
	
}
