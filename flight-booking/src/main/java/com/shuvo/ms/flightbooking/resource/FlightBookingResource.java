package com.shuvo.ms.flightbooking.resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shuvo.ms.flightbooking.models.FareDetails;
import com.shuvo.ms.flightbooking.models.Flight;
import com.shuvo.ms.flightbooking.models.FlightBooking;
import com.shuvo.ms.flightbooking.models.FlightTrip;

@RestController
public class FlightBookingResource {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	List<FlightBooking> availableFlightBooking;
	
	
	@GetMapping(path="/booking/from/{from}/to/{to}/date/{tripdate}")
	public List<FlightBooking>  findAvailableBooking(@PathVariable String from,
			@PathVariable String to , @PathVariable String tripdate){
		FlightTrip[] flightTrips = restTemplate.getForObject("http://search-flight-service/search/from/"+from+"/to/"+to+"/date/"+tripdate,
				FlightTrip[].class);
		List<FlightTrip> flightTripList = Arrays.asList(flightTrips);
		
		return flightTripList.stream().map(flightTrip->{
			logger.info(flightTrip.getFlightid());
			Flight flightDetails = restTemplate.getForObject("http://flight-detail-service/flight/"+flightTrip.getFlightid().trim(), Flight.class);
			FareDetails faredetails = restTemplate.getForObject("http://fare-detail-service/fare/trip/"+flightTrip.getTripid().trim(), FareDetails.class);
			return new FlightBooking(flightDetails,flightTrip,faredetails);
		}).collect(Collectors.toList());
		
		
	}
	
}
