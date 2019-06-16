package com.assignment.template;

import java.math.BigInteger;

import com.assignment.util.PropertiesReader;
import com.google.gson.Gson;

public class Product {
	public String name;
	public String type;
	public BigInteger price;
	public BigInteger shipping;
	public String upc;
	public String description;
	public String manufacturer;
	public String model;
	public static final String PRODUCTPROPERTIES = System.getProperty("user.dir")
			+ "/src/main/resources/product.properties";
	static Product product = new Product();

	public static String getProductDetails() {
		PropertiesReader.load(PRODUCTPROPERTIES);
		commonBody();
		product.name = PropertiesReader.get("name");
		String jsonString = new Gson().toJson(product);
		System.out.println("jsonString = " + jsonString);
		return jsonString;
	}

	public static String getUpdatedProductDetails() {
		PropertiesReader.load(PRODUCTPROPERTIES);
		commonBody();
		product.name = PropertiesReader.get("name1");
		String jsonString = new Gson().toJson(product);
		System.out.println("jsonString = " + jsonString);
		return jsonString;
	}

	public static String getEmptyProductDetails() {
		PropertiesReader.load(PRODUCTPROPERTIES);
		bodyWithEmptyValues();
		String jsonString = new Gson().toJson(product);
		System.out.println("Request:\n " + jsonString);
		return jsonString;
	}

	public static void commonBody() {
		product.type = PropertiesReader.get("type");
		product.price = new BigInteger(PropertiesReader.get("price"));
		product.shipping = new BigInteger(PropertiesReader.get("shipping"));
		product.upc = PropertiesReader.get("upc");
		product.description = PropertiesReader.get("description");
		product.manufacturer = PropertiesReader.get("manufacturer");
		product.model = PropertiesReader.get("model");
	}

	public static void bodyWithEmptyValues() {
		product.name = "";
		product.type = "";
		product.upc = "";
		product.description = "";
		product.manufacturer = "";
		product.model = "";
	}

	public static String getCustomBody(String name, String type, String price, String shipping, String upc,
			String description, String manufacturer, String model) {
		PropertiesReader.load(PRODUCTPROPERTIES);
		customBody(type, price, shipping, upc, description, manufacturer, model);
		product.name = name;
		String jsonString = new Gson().toJson(product);
		System.out.println("Request:\n " + jsonString);
		return jsonString;
	}

	public static void customBody(String type, String price, String shipping, String upc, String description,
			String manufacturer, String model) {
		product.type = type;
		product.price = new BigInteger(price);
		product.shipping = new BigInteger(shipping);
		product.upc = upc;
		product.description = description;
		product.manufacturer = manufacturer;
		product.model = model;
	}

	public static String getEmptyBodyforProductDetails() {
		PropertiesReader.load(PRODUCTPROPERTIES);
		String jsonString = new Gson().toJson("");
		System.out.println("Request:\n " + jsonString);
		return jsonString;
	}

	public static String getProductDetailsWithoutName() {
		Product product = new Product();
		PropertiesReader.load(PRODUCTPROPERTIES);
		bodyWithOutNameField();
		String jsonString = new Gson().toJson(product);
		System.out.println("Request:\n " + jsonString);
		return jsonString;
	}

	public static void bodyWithOutNameField() {
		Product product = new Product();
		product.type = PropertiesReader.get("type");
		product.price = new BigInteger(PropertiesReader.get("price"));
		product.shipping = new BigInteger(PropertiesReader.get("shipping"));
		product.upc = PropertiesReader.get("upc");
		product.description = PropertiesReader.get("description");
		product.manufacturer = PropertiesReader.get("manufacturer");
		product.model = PropertiesReader.get("model");
	}
}