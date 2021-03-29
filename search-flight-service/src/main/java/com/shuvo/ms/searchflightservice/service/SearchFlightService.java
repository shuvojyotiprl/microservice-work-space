package com.shuvo.ms.searchflightservice.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shuvo.ms.searchflightservice.model.FlightTrip;

@Service
public class SearchFlightService {
	
	public List<FlightTrip> findFlight(String from , String to , LocalDate tripDate){
			
		
		//CCHY250420212100001 -- TO(2)FROM(2)DATETIME-DDMMYYYYHHMM-3 digit sl number
		
		Logger logger = LoggerFactory.getLogger(this.getClass());
		
		logger.info("inside findFlight");
		
		List<FlightTrip> listFlight = Arrays.asList
				(
						new FlightTrip("TR001","CCU","HYD",LocalDate.parse("2021-03-27"),"AI9009"),
						new FlightTrip("TR002","DEL","HYD",LocalDate.parse("2021-03-28"),"AI9097"),
						new FlightTrip("TR003","CCU","HYD",LocalDate.parse("2021-03-27"),"INDG99"),
						new FlightTrip("TR012","CCU","HYD",LocalDate.parse("2021-03-29"),"INDG12"),
						new FlightTrip("TR012","CCU","HYD",LocalDate.parse("2021-04-15"),"INDG88"),
						new FlightTrip("TR034","HYD","CCU",LocalDate.parse("2021-04-01"),"AI9002"),
						new FlightTrip("TR056","DEL","BLR",LocalDate.parse("2021-03-28"),"GOAIR12"),
						new FlightTrip("TR0010","BLR","HYD",LocalDate.parse("2021-04-02"),"GOAIR45"),
						new FlightTrip("TR232","BLR","DEL",LocalDate.parse("2021-03-30"),"INDG99")
				);
		
		return listFlight.stream().filter(trip->
			 trip.getFromapt().equals(from) && trip.getToapt().equals(to) &&  
			 (trip.getTripdate().isEqual(tripDate) || (trip.getTripdate().isAfter(tripDate)&&
					 trip.getTripdate().isBefore(tripDate.plusDays(4))))
		).collect(Collectors.toList());		
		
	}
	
}
