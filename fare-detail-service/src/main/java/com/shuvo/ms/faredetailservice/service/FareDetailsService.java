package com.shuvo.ms.faredetailservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shuvo.ms.faredetailservice.model.FareTrip;

@Service
public class FareDetailsService {

	public List<FareTrip> getFareTrips() {
		return Arrays.asList(new FareTrip("TR001", "AI9009", 1200, 12, 78),
				new FareTrip("TR002", "AI9097", 1900, 11, 58), new FareTrip("TR003", "INDG99", 6300, 33, 12),
				new FareTrip("TR012", "INDG12", 7808, 90, 27), new FareTrip("TR034", "AI9002", 8965, 90, 63),
				new FareTrip("TR056", "GOAIR12", 9200, 121, 8), new FareTrip("TR0010", "GOAIR45", 9999, 121, 3),
				new FareTrip("TR232", "INDG99", 5000, 90, 0));
	}

}
