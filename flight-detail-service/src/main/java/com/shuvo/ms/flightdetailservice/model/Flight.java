package com.shuvo.ms.flightdetailservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Flight {
	private String flightId;
	private String flyingPartner;
	private int rating;
	private String flightModel;
}
