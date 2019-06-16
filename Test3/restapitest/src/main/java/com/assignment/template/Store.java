package com.assignment.template;

import com.assignment.util.PropertiesReader;
import com.google.gson.Gson;

public class Store {

	public String name;
	public String type;
	public String address;
	public String address2;
	public String city;
	public String state;
	public String zip;
	public int lat;
	public int lng;
	public String hours;
	public String services;
	protected static final String STOREPROPERTIES = System.getProperty("user.dir")
			+ "/src/main/resources/stores.properties";
	static Store store = new Store();

	public static String getStoreDetails() {
		PropertiesReader.load(STOREPROPERTIES);
		commonBody();
		String jsonString = new Gson().toJson(store);
		System.out.println("Request:\n " + jsonString);
		return jsonString;
	}

	public static String getEmptyStoreDetails() {
		PropertiesReader.load(STOREPROPERTIES);
		bodyWithEmptyValues();
		String jsonString = new Gson().toJson(store);
		System.out.println("Request:\n " + jsonString);
		return jsonString;
	}

	public static String getCustomBodyforStoreDetails(String name, String type, String address, String address2,
			String city, String state, String zip, String lat, String lng, String hours) {
		PropertiesReader.load(STOREPROPERTIES);
		customBody(name, type, address, address2, city, state, zip, lat, lng, hours);
		String jsonString = new Gson().toJson(store);
		System.out.println("Request:\n " + jsonString);
		return jsonString;
	}

	public static String getUpdatedStoreDetails() {
		PropertiesReader.load(STOREPROPERTIES);
		commonBody();
		store.name = PropertiesReader.get("name1");
		String jsonString = new Gson().toJson(store);
		System.out.println("Request:\n " + jsonString);
		return jsonString;
	}

	public static String getBodyWithoutNameField() {
		PropertiesReader.load(STOREPROPERTIES);
		bodyWithOutNameField();
		Store store = new Store();
		String jsonString = new Gson().toJson(store);
		System.out.println("Request:\n " + jsonString);
		return jsonString;
	}

	public static String getEmptyBodyforStoreDetails() {
		PropertiesReader.load(STOREPROPERTIES);
		String jsonString = new Gson().toJson("");
		System.out.println("Request:\n " + jsonString);
		return jsonString;
	}

	public static void commonBody() {
		store.name = PropertiesReader.get("name");
		store.type = PropertiesReader.get("type");
		store.address = PropertiesReader.get("address");
		store.address2 = PropertiesReader.get("address2");
		store.city = PropertiesReader.get("city");
		store.state = PropertiesReader.get("state");
		store.zip = PropertiesReader.get("zip");
		store.lat = Integer.parseInt(PropertiesReader.get("lat"));
		store.lng = Integer.parseInt(PropertiesReader.get("lng"));
		store.hours = PropertiesReader.get("hours");
	}

	public static void bodyWithOutNameField() {
		Store store = new Store();
		store.type = PropertiesReader.get("type");
		store.address = PropertiesReader.get("address");
		store.address2 = PropertiesReader.get("address2");
		store.city = PropertiesReader.get("city");
		store.state = PropertiesReader.get("state");
		store.zip = PropertiesReader.get("zip");
		store.lat = Integer.parseInt(PropertiesReader.get("lat"));
		store.lng = Integer.parseInt(PropertiesReader.get("lng"));
		store.hours = PropertiesReader.get("hours");
	}

	public static void bodyWithEmptyValues() {
		store.name = "";
		store.type = "";
		store.address = "";
		store.address2 = "";
		store.city = "";
		store.state = "";
		store.zip = "";
		store.hours = "";
	}

	public static void customBody(String name, String type, String address, String address2, String city, String state,
			String zip, String lat, String lng, String hours) {
		store.name = name;
		store.type = type;
		store.address = address;
		store.address2 = address2;
		store.city = city;
		store.state = state;
		store.zip = zip;
		store.lat = Integer.parseInt(lat);
		store.lng = Integer.parseInt(lng);
		store.hours = hours;
	}
}