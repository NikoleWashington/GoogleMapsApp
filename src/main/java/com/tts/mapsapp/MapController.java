package com.tts.mapsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.mapsapp.models.Location;

@Controller
public class MapController {
	@Autowired
	MapService mapService;
	
	@GetMapping(path="/")
	public String getDefaultMap(Model model) {
		model.addAttribute("location", new Location());
//		Location location = new Location();
//		location.setCity("Dallas");
//		location.setState("Texas");
//		mapService.addCoordinates(location);
//		System.out.println(location);
		
		return "index.html";
	}
	
	@PostMapping(path="/")
	public String getMapForLocation(Location location, Model model) {
		mapService.addCoordinates(location);
		model.addAttribute("location", location);
		return "index.html";
	}

}
