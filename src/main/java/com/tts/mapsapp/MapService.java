package com.tts.mapsapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tts.mapsapp.models.GeocodingResponse;
import com.tts.mapsapp.models.Location;

// Autowire to create a MapService. We don't want to have to create one
//using a new MapService statement. We want SpringBoot to make one
//We tell SpringBoot it is okay to do so.
@Service //Tells the programmers and SB that it's meant to be a service
public class MapService {
	
	@Value("${api_key}")
	private String apiKey;

	public void addCoordinates(Location location) {
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
				location.getCity() + "," + location.getState() + "&key=" + apiKey;
		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse response = 
				restTemplate.getForObject(url, GeocodingResponse.class);
		Location coordinates = response.getResults().get(0).getGeometry().getLocation();
		location.setLat(coordinates.getLat());
		location.setLng(coordinates.getLng());
	}

}
