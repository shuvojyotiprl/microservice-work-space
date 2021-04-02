package com.shuvo.ms.faredetailservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shuvo.ms.faredetailservice.model.FareTrip;
import com.shuvo.ms.faredetailservice.service.FareDetailsService;

@RestController
public class FareServiceController {

	
		@Autowired
		FareDetailsService fareDetailsService;
		
		Logger logger  = LoggerFactory.getLogger(this.getClass());
		
		@GetMapping(path = "/fare/trip/{tripid}")
		public FareTrip getFareInfo(@PathVariable String tripid){
			logger.info("Fare Detail Service == >" + tripid);
			return fareDetailsService.getFareTrips().stream().filter(fatretrip-> fatretrip.getTripid().equals(tripid)).findFirst().get();	
		}
		
		
}
