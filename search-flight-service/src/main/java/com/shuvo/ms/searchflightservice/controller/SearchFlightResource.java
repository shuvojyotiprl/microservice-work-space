package com.shuvo.ms.searchflightservice.controller;

import java.time.LocalDate;
import java.util.List;

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
	
	
	@GetMapping(path = "/search/from/{from}/to/{to}/date/{tripDate}")
	public List<FlightTrip> fetchFlights(@PathVariable String from ,@PathVariable String to,@PathVariable String tripDate ) {
		LocalDate tripdate = LocalDate.parse(tripDate) ;
		return searchFlightService.findFlight(from,to,tripdate);
	}
	
	
	
	
}
