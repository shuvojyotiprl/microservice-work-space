package com.shuvo.ms.searchflightservice.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter  @NoArgsConstructor @AllArgsConstructor
public class FlightTrip {
	
	
	private String tripid;
	private String fromapt;
	private String toapt;
	private LocalDate tripdate;
	private String flightid;
	
	
	
}
