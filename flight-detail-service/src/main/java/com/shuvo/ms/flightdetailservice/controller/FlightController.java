package com.shuvo.ms.flightdetailservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shuvo.ms.flightdetailservice.model.Flight;
import com.shuvo.ms.flightdetailservice.service.FlightDetailService;

@RestController
public class FlightController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FlightDetailService flightDetailService;
	
	@GetMapping(path="/flight/{flightId}")
	public Flight findFlightDetails(@PathVariable String flightId){
		
		logger.info("Flight Details Service == > "+flightId);
		
		return flightDetailService.getFlightDetails(flightId);
		
	}
 
}
