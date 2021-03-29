package com.shuvo.ms.flightbooking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FlightBooking {
		
	private Flight flight;
	private FlightTrip flightTrip;
	private FareDetails faredetails;
	
}
