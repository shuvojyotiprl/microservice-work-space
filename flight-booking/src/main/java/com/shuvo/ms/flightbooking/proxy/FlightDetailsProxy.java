package com.shuvo.ms.flightbooking.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shuvo.ms.flightbooking.models.Flight;

@FeignClient("netflix-zuul-api-gateway-server")
public interface FlightDetailsProxy {
	
	@GetMapping("flight-detail-service/flight/{flightId}")
	public Flight flightDetailsService(
				@PathVariable("flightId") String flightId
			);
}
