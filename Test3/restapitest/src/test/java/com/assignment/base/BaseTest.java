package com.assignment.base;

import org.testng.annotations.BeforeSuite;

import com.assignment.util.PropertiesReader;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseTest {

	protected static String baseURI;
	protected Response response;
	protected static final String ENVIRONMENTPROPERTIES = System.getProperty("user.dir")
			+ "/src/main/resources/env.properties";

	protected static void envDetails() {
		PropertiesReader.load(ENVIRONMENTPROPERTIES);
		baseURI = PropertiesReader.get("url");
	}

	@BeforeSuite
	public void setUp() {
		envDetails();
		RestAssured.baseURI = baseURI;
	}
}
