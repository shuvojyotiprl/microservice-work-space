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

import com.shuvo.ms.flightbooking.models.FareDetails;
import com.shuvo.ms.flightbooking.models.Flight;
import com.shuvo.ms.flightbooking.models.FlightBooking;
import com.shuvo.ms.flightbooking.models.FlightTrip;
import com.shuvo.ms.flightbooking.proxy.FareDetailsProxy;
import com.shuvo.ms.flightbooking.proxy.FlightDetailsProxy;
import com.shuvo.ms.flightbooking.proxy.SearchFlightProxy;

@RestController
public class FlightBookingResource {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*@Autowired
	private RestTemplate restTemplate;*/
	
	@Autowired
	List<FlightBooking> availableFlightBooking;
	
	@Autowired
	SearchFlightProxy searchFlightProxy;
	
	@Autowired
	FlightDetailsProxy flightDetailsProxy;
	
	@Autowired
	FareDetailsProxy fareDetailsProxy;
	
	
	
	
	
	@GetMapping(path="/booking/from/{from}/to/{to}/date/{tripdate}")
	public List<FlightBooking>  findAvailableBooking(@PathVariable String from,
			@PathVariable String to , @PathVariable String tripdate){
		
		
		logger.info("Flight Booking Service == > "+from + " " +to + "  "+tripdate);
		
		/*FlightTrip[] flightTrips = restTemplate.getForObject("http://search-flight-service/search/from/"+from+"/to/"+to+"/date/"+tripdate,
				FlightTrip[].class);*/
		
		FlightTrip[] flightTrips = searchFlightProxy.getFlightTrips(from, to, tripdate);
		
		
		List<FlightTrip> flightTripList = Arrays.asList(flightTrips);
		
		return flightTripList.stream().map(flightTrip->{
			
			
			
			/*Flight flightDetails 
			= restTemplate.getForObject("http://flight-detail-service/flight/"+flightTrip.getFlightid().trim(), Flight.class);*/
			
			Flight flightDetails = flightDetailsProxy.flightDetailsService(flightTrip.getFlightid().trim());
			
			
			
			/*FareDetails faredetails
			= restTemplate.getForObject("http://fare-detail-service/fare/trip/"+flightTrip.getTripid().trim(), FareDetails.class);*/
			
			FareDetails faredetails = fareDetailsProxy.getFareDetails(flightTrip.getTripid().trim());
			
			return new FlightBooking(flightDetails,flightTrip,faredetails);
		}).collect(Collectors.toList());
		
		
	}
	
}
