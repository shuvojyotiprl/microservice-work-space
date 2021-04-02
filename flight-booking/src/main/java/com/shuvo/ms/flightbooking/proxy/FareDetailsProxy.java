package com.shuvo.ms.flightbooking.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shuvo.ms.flightbooking.models.FareDetails;

@FeignClient("netflix-zuul-api-gateway-server")
public interface FareDetailsProxy {
	
	@GetMapping("fare-detail-service/fare/trip/{tripId}")
	public FareDetails getFareDetails(@PathVariable("tripId") String tripId);
}
