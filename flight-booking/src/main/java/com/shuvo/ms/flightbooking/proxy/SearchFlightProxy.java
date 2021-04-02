package com.shuvo.ms.flightbooking.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shuvo.ms.flightbooking.models.FlightTrip;

@FeignClient(name = "netflix-zuul-api-gateway-server")
public interface SearchFlightProxy {
	@GetMapping("search-flight-service/search/from/{from}/to/{to}/date/{tripdate}")
	public FlightTrip[] getFlightTrips(
			@PathVariable("from") String from ,
			@PathVariable("to") String to,
			@PathVariable("tripdate") String tripdate
			);
}
