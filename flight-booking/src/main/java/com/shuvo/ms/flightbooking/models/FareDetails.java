package com.shuvo.ms.flightbooking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FareDetails {
	private double fare;
	private int availableseat;
}
