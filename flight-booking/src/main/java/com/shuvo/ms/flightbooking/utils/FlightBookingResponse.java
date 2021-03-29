package com.shuvo.ms.flightbooking.utils;

import java.util.List;

import com.shuvo.ms.flightbooking.models.CustomerDetails;
import com.shuvo.ms.flightbooking.models.FlightBooking;
import com.shuvo.ms.flightbooking.models.PaymentDetails;
import com.shuvo.ms.flightbooking.models.Seat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FlightBookingResponse {
	
	
	private FlightBooking flightBooking;
	
	private CustomerDetails customerDetails;
	
	private PaymentDetails paymentDetails;
	
	private List<Seat> seatDetails;
	
}
