package com.shuvo.ms.searchflightservice.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shuvo.ms.searchflightservice.model.FlightTrip;
import com.shuvo.ms.searchflightservice.service.SearchFlightService;

@RestController
public class SearchFlightResource {

	@Autowired
	private SearchFlightService searchFlightService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(path = "/search/from/{from}/to/{to}/date/{tripDate}")
	public List<FlightTrip> fetchFlights(@PathVariable String from ,@PathVariable String to,@PathVariable String tripDate ) {
		
		logger.info("Sesrch Flight Service == > ");
		
		LocalDate tripdate = LocalDate.parse(tripDate) ;
		return searchFlightService.findFlight(from,to,tripdate);
	}
	
	
	
	
}
