package com.shuvo.ms.flightbooking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Flight {
	private String flightId;
	private String flyingPartner;
	private int rating;
	private String flightModel;
}
