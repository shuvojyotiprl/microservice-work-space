package com.shuvo.ms.faredetailservice.controller;

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
		
		
		
		@GetMapping(path = "/fare/trip/{tripid}")
		public FareTrip getFareInfo(@PathVariable String tripid){
			return fareDetailsService.getFareTrips().stream().filter(fatretrip-> fatretrip.getTripid().equals(tripid)).findFirst().get();	
		}
		
		
}
