package com.shuvo.ms.faredetailservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class FareTrip {
	@JsonIgnore
	private String tripid;
	@JsonIgnore
	private String flightid;
	private double fare;
	private int availableseat;
	@JsonIgnore
	private int bookedseat;
}
