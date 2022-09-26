package com.tts.mapsapp.models;

import java.util.List;

import lombok.Data;

@Data
public class Geocoding {
	//private List<AddressComponent>address_components;
	private String formatted_adddress;
	private Geometry geometry;
	private String place_id;
	private List<String> types;

}
