package com.shuvo.ms.flightdetailservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shuvo.ms.flightdetailservice.model.Flight;

@Service 
public class FlightDetailService {
	
	
	public Flight getFlightDetails(String flightId) {
		
		
		return Arrays.asList(new Flight("AI9009", "AirIndia", 6, "Classic"),
				new Flight("AI9097", "AirIndia", 8, "Classic"),new Flight("AI9002", "Air India", 3, "Sports"),
				new Flight("INDG99", "IndiGo", 9, "Bombardier"),
				new Flight("INDG12", "IndiGo", 10, "Vintage"),
				new Flight("GOAIR12", "Go Air", 6, "Air Bus"),
				new Flight("GOAIR45", "Go Air", 9, "Locomotive")
				).stream().filter(flight-> flight.getFlightId().equals(flightId)).findFirst().get();
				
	}
	
}
